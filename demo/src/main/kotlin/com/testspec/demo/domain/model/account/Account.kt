package com.testspec.demo.domain.model.account

import com.testspec.demo.domain.model.account.type.FullName
import com.testspec.demo.domain.model.account.type.MailAddress

open class Account(val fullName: FullName, val mailAddress: MailAddress) {
}