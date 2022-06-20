package com.testspec.demo.domain.model.testcase.read

import com.testspec.demo.domain.model.testcase.businessrules.TestCaseStatus
import com.testspec.demo.domain.model.testcase.type.Description
import com.testspec.demo.domain.model.testcase.type.TestCaseId
import com.testspec.demo.domain.type.Expected
import com.testspec.demo.domain.type.TestTarget

class ReadTestCase private constructor(
    private val testCaseId: TestCaseId,
    private val target: TestTarget,
    private val expected: Expected,
    private val description: Description,
    private val status: TestCaseStatus = TestCaseStatus.UNCOMPLETED
) {

    companion object {
        fun create(testCaseId: Int, target: String, expected: String, testSupplement: String): ReadTestCase {
            return ReadTestCase(
                TestCaseId(testCaseId),
                TestTarget(target),
                Expected(expected),
                Description(testSupplement)
            )
        }
    }

    override fun toString(): String {
        return """
            testCaseId: ${this.testCaseId}, target: ${this.target}, expected: ${this.expected},
            testSupplement: ${this.description}, status: ${this.status}
        """.trimIndent()
    }

}
