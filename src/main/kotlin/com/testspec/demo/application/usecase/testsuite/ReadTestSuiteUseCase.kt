package com.testspec.demo.application.usecase.testsuite

import com.testspec.demo.domain.model.testframe.testsuite.read.TestSuiteQueryParam
import com.testspec.demo.infrastructure.repositoryImpl.TestCaseRepositoryImpl
import com.testspec.demo.infrastructure.repositoryImpl.TestSuiteRepositoryImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ReadTestSuiteUseCase @Autowired constructor(
    val testSuiteRepositoryImpl: TestSuiteRepositoryImpl,
    val tagRepositoryImpl: TestCaseRepositoryImpl
) {

    fun findAllWithTags(queryParam: TestSuiteQueryParam) {
        val testSuiteList = testSuiteRepositoryImpl.findAll(queryParam)
    }

}
