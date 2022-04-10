package com.testspec.demo.presentation.controller

import com.testspec.demo.application.service.TestCaseService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller

@Controller
class TestCaseController @Autowired constructor(
    val testCaseService: TestCaseService
) {
}