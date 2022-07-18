package com.testspec.demo.domain.model.testframe.type

@JvmInline
value class Description (val value: String) {

    override fun toString(): String {
        return this.value
    }

}
