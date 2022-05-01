package com.testspec.demo.domain.model.testspecification

import com.testspec.demo.domain.model.account.approver.Approver
import com.testspec.demo.domain.model.account.tester.Testers
import com.testspec.demo.domain.model.testspecification.type.Suppliers
import com.testspec.demo.domain.model.testspecification.type.TestedDt
import com.testspec.demo.domain.model.testspecification.type.Title
import com.testspec.demo.domain.type.TestSupplement

/**
 * テスト仕様書
 */
class TestSpec(
    val testSpecId: Int,
    val title: Title,
    val testedDt: TestedDt,
    val testers: Testers?,
    val approver: Approver?,
    val suppliers: Suppliers?,
    val testSupplement: TestSupplement?
) {
}
