package com.testspec.demo.domain.model.testspec.read

import com.testspec.demo.domain.model.account.approver.ApproverList
import com.testspec.demo.domain.model.account.tester.TesterList
import com.testspec.demo.domain.model.supplier.SupplierList
import com.testspec.demo.domain.model.testspec.type.TestedDt
import com.testspec.demo.domain.model.testspec.type.Title
import com.testspec.demo.domain.type.TestSupplement

/**
 * テスト仕様書
 */
class ReadTestSpec(
    val testSpecId: Int,
    val title: Title,
    val testedDt: TestedDt,
    val testers: TesterList?,
    val approverList: ApproverList?,
    val supplierList: SupplierList?,
    val testSupplement: TestSupplement?
) {
}
