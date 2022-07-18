package com.testspec.demo.domain.model.testframe.testsuite.type

@JvmInline
value class TestSuiteId(val value: Int) {

    override fun toString(): String {
        return "${this.value}"
    }

}
