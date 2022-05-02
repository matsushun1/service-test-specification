package com.testspec.demo.domain.model.role

import com.testspec.demo.domain.model.role.type.RoleName
import com.testspec.demo.domain.model.role.type.RoleType

/**
 * ロール
 */
class Role(
    val roleId: Int,
    val roleName: RoleName,
    val roleType: RoleType
) {
}