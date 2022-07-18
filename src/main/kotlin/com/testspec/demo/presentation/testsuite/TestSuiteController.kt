package com.testspec.demo.presentation.testsuite

import com.testspec.demo.application.usecase.testsuite.ReadTestSuiteUseCase
import com.testspec.demo.domain.model.testframe.testsuite.read.ReadTestSuiteWithTags
import com.testspec.demo.domain.model.testframe.testsuite.read.TestSuiteQueryParam
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/testSuite")
class TestSuiteController @Autowired constructor(
    val readTestSuiteUseCase: ReadTestSuiteUseCase
) {

    @GetMapping("/withTags")
    fun findWithTags(@RequestBody queryParam: TestSuiteQueryParam): List<ReadTestSuiteWithTags> {
        val r = readTestSuiteUseCase.findAllWithTags(queryParam)
        return readTestSuiteUseCase.findAllWithTags(queryParam)
    }

}
