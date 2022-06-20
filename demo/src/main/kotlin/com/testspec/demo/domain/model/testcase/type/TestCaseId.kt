package com.testspec.demo.domain.model.testcase.type

class TestCaseId (private val testCaseId: Int) {

    fun value() = this.testCaseId
    override fun toString(): String {
        return this.testCaseId.toString()
    }
}
