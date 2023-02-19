package com.testspec.demo.presentation.testcase

import com.testspec.demo.domain.model.testframe.testcase.TestCase
import com.testspec.demo.domain.model.testframe.testcase.TestCaseQueryParam
import com.testspec.demo.domain.model.testframe.testcase.update.TestCaseForm
import com.testspec.demo.infrastructure.repositoryImpl.TestCaseRepositoryImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/testCase")
class TestCaseController @Autowired constructor(
    val testCaseRepositoryImpl: TestCaseRepositoryImpl
) {

    @GetMapping("")
    fun findAll(queryParam: TestCaseQueryParam): List<TestCase> {
        return testCaseRepositoryImpl.findAll(queryParam)
    }

    @PostMapping("")
    fun create(@RequestBody testCaseForm: TestCaseForm) {

    }

}
