package com.testspec.demo.infrastructure.repositoryImpl

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class TestCaseRepositoryImplTest @Autowired constructor(
    val testCaseRepositoryImpl: TestCaseRepositoryImpl
) {

    // TODO: jooq検証が完了次第削除
    @Test
    fun `全件正常取得チェック`() {
        testCaseRepositoryImpl.findAll()
            .forEach { println(it) }
    }
}
