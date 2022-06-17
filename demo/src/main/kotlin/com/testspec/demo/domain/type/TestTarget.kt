package com.testspec.demo.domain.type

/**
 * テスト対象項目
 */
class TestTarget(
    private val target: String
) {
    fun value(): String = this.target
    override fun toString(): String {
        return this.target
    }
}