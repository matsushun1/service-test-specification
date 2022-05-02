package com.testspec.demo.domain.model.account.tester

import com.testspec.demo.domain.model.account.type.Email
import com.testspec.demo.domain.model.account.type.FullName

/**
 * テスター
 */
class Tester(
    val testerId: Int,
    val testerName: FullName,
    val email: Email
) {
}