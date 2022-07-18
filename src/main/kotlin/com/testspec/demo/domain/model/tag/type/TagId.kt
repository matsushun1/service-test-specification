package com.testspec.demo.domain.model.tag.type

@JvmInline
value class TagId(val value: Int) {

    override fun toString(): String {
        return "${this.value}"
    }

}
