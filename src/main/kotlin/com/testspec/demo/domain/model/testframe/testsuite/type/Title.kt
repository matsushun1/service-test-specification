package com.testspec.demo.domain.model.testframe.testsuite.type

@JvmInline
value class Title(val value: String) {

    override fun toString(): String {
        return this.value
    }

}
