package com.testspec.demo.application.service

import com.testspec.demo.domain.model.testcase.TestCase
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TestCaseService @Autowired constructor(
    val testCase: TestCase
) {
}
