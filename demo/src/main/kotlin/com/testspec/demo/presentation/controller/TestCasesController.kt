package com.testspec.demo.presentation.controller

import com.testspec.demo.application.service.TestCaseService
import org.springframework.beans.factory.annotation.Autowired

class TestCasesController @Autowired constructor(
    val testCaseService: TestCaseService
) {
    fun create() {
        testCaseService.create()
    }
}