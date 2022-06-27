package com.testspec.demo.domain.repository

import com.testspec.demo.domain.model.testframe.testsuite.read.ReadTestSuite
import com.testspec.demo.domain.model.testframe.testsuite.read.TestSuiteQueryParam
import org.springframework.stereotype.Repository

@Repository
interface TestSuiteRepository {

    fun findAll(queryParam: TestSuiteQueryParam): List<ReadTestSuite>

}
