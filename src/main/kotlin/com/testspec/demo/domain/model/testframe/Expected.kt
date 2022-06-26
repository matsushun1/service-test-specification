package com.testspec.demo.domain.model.testframe

/**
 * 動作期待内容
 */
class Expected(
    private val expected: String
) {
    override fun toString(): String {
        return this.expected
    }
}