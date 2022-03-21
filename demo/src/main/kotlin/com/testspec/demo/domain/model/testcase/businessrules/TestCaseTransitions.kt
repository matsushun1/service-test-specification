package com.testspec.demo.domain.model.testcase.businessrules

import java.util.*

/**
 * テストケースの実施ステータスルール
 */
class TestCaseTransitions {
    private val allowed = mutableMapOf<TestCaseStatus, EnumSet<TestCaseStatus>>()

    init {
        this.allowed[TestCaseStatus.UNCOMPLETED] = EnumSet.of(TestCaseStatus.TESTING, TestCaseStatus.COMPLETED)
        this.allowed[TestCaseStatus.TESTING] = EnumSet.of(TestCaseStatus.COMPLETED, TestCaseStatus.PENDING, TestCaseStatus.FIXING)
        this.allowed[TestCaseStatus.COMPLETED] = EnumSet.of(TestCaseStatus.PENDING, TestCaseStatus.FIXING)
        this.allowed[TestCaseStatus.PENDING] = EnumSet.of(TestCaseStatus.UNCOMPLETED, TestCaseStatus.COMPLETED, TestCaseStatus.FIXING)
        this.allowed[TestCaseStatus.FIXING] = EnumSet.of(TestCaseStatus.UNCOMPLETED, TestCaseStatus.COMPLETED, TestCaseStatus.PENDING)
    }

    /**
     * fromステータスからtoステータスへ切り替え可能か
     */
    fun canTransit(from: TestCaseStatus, to: TestCaseStatus): Boolean {
        val allowedStatus = this.allowed[from]
        return allowedStatus?.contains(to) ?: false
    }
}