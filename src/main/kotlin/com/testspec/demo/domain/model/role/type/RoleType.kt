package com.testspec.demo.domain.model.role.type

/**
 * ロールタイプ
 * ビットフラグで管理
 */
enum class RoleType(val value: Int) {
    APPROVER(1),
    TESTER(2)
}