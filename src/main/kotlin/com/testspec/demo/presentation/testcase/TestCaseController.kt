package com.testspec.demo.presentation.testcase

import com.testspec.demo.domain.model.testframe.testcase.read.ReadTestCase
import com.testspec.demo.domain.model.testframe.testcase.read.TestCaseQueryParam
import com.testspec.demo.infrastructure.repositoryImpl.TestCaseRepositoryImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/testCase")
class TestCaseController @Autowired constructor(
    val testCaseRepositoryImpl: TestCaseRepositoryImpl
) {

    @GetMapping("")
    fun findAll(queryParam: TestCaseQueryParam): List<ReadTestCase> {
        return testCaseRepositoryImpl.findAll(queryParam)
    }

}
