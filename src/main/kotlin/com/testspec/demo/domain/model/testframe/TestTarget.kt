package com.testspec.demo.domain.model.testframe

/**
 * テスト対象項目
 */
@JvmInline
value class TestTarget(
    private val value: String
) {

    init {

    }

    companion object {
        
    }

    override fun toString(): String {
        return this.value
    }
}
