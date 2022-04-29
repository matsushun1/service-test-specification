package com.testspec.demo.domain.model.testspecification

import com.testspec.demo.domain.model.account.approver.Approver
import com.testspec.demo.domain.model.account.tester.Testers
import com.testspec.demo.domain.model.testspecification.type.SubmissionTo
import com.testspec.demo.domain.model.testspecification.type.TestedDt
import com.testspec.demo.domain.model.testspecification.type.Title
import com.testspec.demo.domain.type.TestSupplement

/**
 * テスト仕様書
 */
class TestSpecification(
    val testSpecificationId: Int,
    val title: Title,
    val testedDt: TestedDt,
    val testers: Testers?,
    val approver: Approver?,
    val submissionTo: SubmissionTo?, // TODO: 納品先マスタテーブルを作成する
    val testSupplement: TestSupplement?
) {
}
