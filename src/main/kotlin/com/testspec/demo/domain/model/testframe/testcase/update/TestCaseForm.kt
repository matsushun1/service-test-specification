package com.testspec.demo.domain.model.testframe.testcase.update

data class TestCaseForm(
    val testCaseId: Int,
    val target: String,
    val expected: String,
    val description: String?,
    val status: Int,
    val parentSuiteId: Int?
)