package com.testspec.demo.domain.model.testframe.testcase.read

import com.testspec.demo.domain.model.testframe.Expected
import com.testspec.demo.domain.model.testframe.TestTarget
import com.testspec.demo.domain.model.testframe.testcase.businessrules.TestCaseStatus
import com.testspec.demo.domain.model.testframe.testcase.type.TestCaseId
import com.testspec.demo.domain.model.testframe.testsuite.type.TestSuiteId
import com.testspec.demo.domain.model.testframe.type.Description

class ReadTestCase private constructor(
    val testCaseId: TestCaseId,
    val target: TestTarget,
    val expected: Expected,
    val description: Description,
    val status: TestCaseStatus,
    val parentSuiteId: TestSuiteId?
) {

    companion object {
        fun create(testCaseId: Int, target: String, expected: String, description: String, status: Int, parentSuiteId: Int?): ReadTestCase {
            return ReadTestCase(
                testCaseId = TestCaseId(testCaseId),
                target = TestTarget(target),
                expected = Expected(expected),
                description = Description(description),
                status = TestCaseStatus.getOrdinalMap()[status] ?: TestCaseStatus.UNCOMPLETED,
                parentSuiteId = parentSuiteId?.let { TestSuiteId(it) }
            )
        }
    }

    override fun toString(): String {
        return """
            testCaseId: ${this.testCaseId}, target: ${this.target}, expected: ${this.expected},
            testSupplement: ${this.description}, status: ${this.status}, parentSuiteId: ${this.parentSuiteId}
        """.trimIndent()
    }

}
