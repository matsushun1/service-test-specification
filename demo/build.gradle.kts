import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.6.4"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	id("io.gitlab.arturbosch.detekt").version("1.20.0-RC2")
	id("nu.studer.jooq") version "7.1.1"
	kotlin("jvm") version "1.6.10"
	kotlin("plugin.spring") version "1.6.10"
}

buildscript {
	configurations["classpath"].resolutionStrategy.eachDependency {
		if (requested.group == "org.jooq") {
			useVersion("3.16.4")
		}
	}
}

detekt {
	toolVersion = "1.20.0-RC2"
	config = files("config/detekt/detekt.yml")
	buildUponDefaultConfig = true
	tasks.withType<io.gitlab.arturbosch.detekt.Detekt>().configureEach {
		reports {
			html {
				isEnabled = true
				outputLocation.set(file("config/detekt/reports/report.html"))
			}
		}
	}
}

group = "com.testspec"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-jdbc")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	runtimeOnly("org.postgresql:postgresql:42.3.2")
	jooqGenerator("org.postgresql:postgresql:42.3.2")
	jooqGenerator("jakarta.xml.bind:jakarta.xml.bind-api:3.0.1")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

jooq {
	version.set("3.16.4")
	configurations {
		create("main") {
			generateSchemaSourceOnCompilation.set(false)
			jooqConfiguration.apply {
				logging = org.jooq.meta.jaxb.Logging.WARN
				jdbc.apply {
					driver = "org.postgresql.Driver"
					url = "jdbc:postgresql://localhost/test_specification"
					user = "postgres"
					password = "postgres"
				}
				generator.apply {
					strategy.name = "org.jooq.codegen.DefaultGeneratorStrategy"
					name = "org.jooq.codegen.DefaultGenerator"
					database.apply {
						name = "org.jooq.meta.postgres.PostgresDatabase"
						inputSchema = "public"
						forcedTypes = listOf(
							org.jooq.meta.jaxb.ForcedType().apply {
								name = "varchar"
								includeExpression = ".*"
								includeTypes = "JSONB?"
							},
							org.jooq.meta.jaxb.ForcedType().apply {
								name = "varchar"
								includeExpression = ".*"
								includeTypes = "INET"
							}
						)
					}
					generate.apply {
						isDeprecated = false
						isRecords = false
						isPojos = false
						isImmutablePojos = true
						isFluentSetters = true
					}
					target.apply {
						encoding = "UTF-8"
						packageName = "com"
						directory = "build/generated-src/jooq/main"
					}
				}
			}
		}
	}
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.named<nu.studer.gradle.jooq.JooqGenerate>("generateJooq") {
	allInputsDeclared.set(true)
	(launcher::set)(javaToolchains.launcherFor {
		languageVersion.set(JavaLanguageVersion.of(11))
	})
}

