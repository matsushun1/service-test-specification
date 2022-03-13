package com.testspec.demo.domain.model.testcase

import com.testspec.demo.domain.model.testcase.businessrules.TestCaseStatus
import com.testspec.demo.domain.type.Tags
import com.testspec.demo.domain.type.TestSupplement
import com.testspec.demo.domain.type.Version

/**
 * テストケース：テスト項目を表現する最小単位
 */
class TestCase(
    val testTarget: TestTarget,
    val expected: Expected,
    val parameters: Parameters,
    val version: Version,
    val tags: Tags,
    val testSupplement: TestSupplement,
    val testCaseStatus: TestCaseStatus
) {
}