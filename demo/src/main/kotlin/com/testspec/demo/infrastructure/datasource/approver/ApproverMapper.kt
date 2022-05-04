package com.testspec.demo.infrastructure.datasource.approver

import com.testspec.demo.domain.model.account.approver.Approver
import com.testspec.demo.domain.model.role.type.RoleType
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Result
import org.apache.ibatis.annotations.Results
import org.apache.ibatis.annotations.SelectProvider
import org.apache.ibatis.jdbc.SQL

@Mapper
interface ApproverMapper {

    fun findByTestSpecId(testSpecId: Int, approverType: Int = RoleType.APPROVER.value): List<Approver>

}