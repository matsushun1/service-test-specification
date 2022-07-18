package com.testspec.demo.domain.model.tag.type

@JvmInline
value class TagName(val value: String) {

    override fun toString(): String {
        return this.value
    }
}
