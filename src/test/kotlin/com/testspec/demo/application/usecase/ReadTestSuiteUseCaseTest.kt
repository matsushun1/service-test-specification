package com.testspec.demo.application.usecase

import com.testspec.demo.application.usecase.testsuite.ReadTestSuiteUseCase
import com.testspec.demo.domain.model.testframe.testsuite.read.TestSuiteQueryParam
import com.testspec.demo.domain.model.testframe.testsuite.type.Limit
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ReadTestSuiteUseCaseTest @Autowired constructor(
    val readTestSuiteUseCase: ReadTestSuiteUseCase
) {

    @Test
    fun `jooq検索確認`() {
        readTestSuiteUseCase.findAllWithTags(TestSuiteQueryParam(limit = Limit(100)))
            .forEach {
                println(it)
            }
    }
}
