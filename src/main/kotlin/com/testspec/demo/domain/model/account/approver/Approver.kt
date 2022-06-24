package com.testspec.demo.domain.model.account.approver

import com.testspec.demo.domain.model.account.type.Email
import com.testspec.demo.domain.model.account.type.FullName

/**
 * テスト仕様書の納品責任者
 */
class Approver(
    val approverId: Int,
    val approverName: FullName,
    val email: Email
) {
}