package com.testspec.demo.domain.model.testframe.testsuite.type

import java.io.Serializable

@JvmInline
value class ParentSuiteId(val value: Int): Serializable {

    override fun toString(): String {
        return "${this.value}"
    }

}
