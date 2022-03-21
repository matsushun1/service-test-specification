package com.testspec.demo.domain.model.testcase.type

/**
 * テスト対象項目
 */
class TestTarget(
    private val target: String
) {
    fun value(): String = this.target
}