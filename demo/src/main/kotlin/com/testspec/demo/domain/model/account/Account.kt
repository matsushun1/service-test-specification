package com.testspec.demo.domain.model.account

import com.testspec.demo.domain.model.account.type.Email
import com.testspec.demo.domain.model.account.type.FullName

open class Account(
    val accountId: Int,
    val accountName: FullName,
    val email: Email
) {
}