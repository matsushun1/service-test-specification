package com.testspec.demo.domain.model.testsuite

import com.testspec.demo.domain.model.testcase.TestCases
import com.testspec.demo.domain.type.*

/**
 * テストスイート：テストケースをまとめるクラス
 */
class TestSuite(
    val testCases: TestCases,
    val testTarget: TestTarget,
    val expected: Expected,
    val tags: Tags,
    val testSupplement: TestSupplement
) {
}