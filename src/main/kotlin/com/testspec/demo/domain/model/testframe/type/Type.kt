package com.testspec.demo.domain.model.testframe.type

/**
 * テストスイートかテストケースかを決める定数
 */
enum class Type(val type: Int) {
    TEST_CASE(1),
    TEST_SUITE(2);
}