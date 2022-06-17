package com.testspec.demo.domain.type

/**
 * テスト実施時補足事項
 */
class TestSupplement(
    val testSupplement: String
) {

    override fun toString(): String {
        return this.testSupplement
    }
}