package com.testspec.demo.domain.model.testframe.testcase.type

@JvmInline
value class TestCaseId (val value: Int) {

    override fun toString(): String {
        return this.value.toString()
    }
}
