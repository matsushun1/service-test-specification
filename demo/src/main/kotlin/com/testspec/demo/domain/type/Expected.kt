package com.testspec.demo.domain.type

/**
 * 動作期待内容
 */
class Expected(
    private val expected: String
) {
    fun expected(): String = this.expected
}