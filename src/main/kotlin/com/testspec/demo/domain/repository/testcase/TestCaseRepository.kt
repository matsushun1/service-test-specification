package com.testspec.demo.domain.repository.testcase

import com.testspec.demo.domain.model.testframe.testcase.TestCase
import com.testspec.demo.domain.model.testframe.testcase.TestCaseQueryParam
import org.springframework.stereotype.Repository

@Repository
interface TestCaseRepository {

    fun findAll(queryParam: TestCaseQueryParam): List<TestCase>
}
