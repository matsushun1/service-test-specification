package com.testspec.demo.domain.model.testcase.read

import com.testspec.demo.domain.model.testcase.businessrules.TestCaseStatus
import com.testspec.demo.domain.type.Expected
import com.testspec.demo.domain.type.TestSupplement
import com.testspec.demo.domain.type.TestTarget

class ReadTestCase private constructor(
    private val testCaseId: Int,
    private val target: TestTarget,
    private val expected: Expected,
    private val testSupplement: TestSupplement,
    private val status: TestCaseStatus = TestCaseStatus.UNCOMPLETED
) {

    companion object {
        fun create(testCaseId: Int, target: String, expected: String, testSupplement: String): ReadTestCase {
            return ReadTestCase(
                testCaseId,
                TestTarget(target),
                Expected(expected),
                TestSupplement(testSupplement)
            )
        }
    }

    override fun toString(): String {
        return """
            testCaseId: ${this.testCaseId}, target: ${this.target}, expected: ${this.expected},
            testSupplement: ${this.testSupplement}, status: ${this.status}
        """.trimIndent()
    }

}
