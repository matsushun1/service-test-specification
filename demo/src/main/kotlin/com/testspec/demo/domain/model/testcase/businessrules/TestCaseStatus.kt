package com.testspec.demo.domain.model.testcase.businessrules

/**
 * テストケース実施ステータス
 */
enum class TestCaseStatus(status: Int) {
        UNCOMPLETED(0),
        TESTING(1),
        COMPLETED(2),
        PENDING(3),
        FIXING(4);
}