package com.testspec.demo.domain.repository.testcase

import com.testspec.demo.domain.model.testframe.testcase.read.ReadTestCase
import com.testspec.demo.domain.model.testframe.testcase.read.TestCaseQueryParam
import org.springframework.stereotype.Repository

@Repository
interface TestCaseRepository {

    fun findAll(queryParam: TestCaseQueryParam): List<ReadTestCase>
}
