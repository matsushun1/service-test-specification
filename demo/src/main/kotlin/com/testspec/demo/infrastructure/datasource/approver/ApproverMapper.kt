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

    @Results(id = "findApproverByTestSpecId", value = [
        Result(column = "account_id", property = "approverId"),
        Result(column = "account_name", property = "approverName"),
        Result(column = "email", property = "email")
    ])
    @SelectProvider(type = ApproverProvider::class, method = "findByTestSpecId")
    fun findByTestSpecId(testSpecId: Int, approverType: Int = RoleType.APPROVER.value): List<Approver>

    class ApproverProvider {
        fun findByTestSpecId(testSpecId: Int, approverType: Int): String {
            return SQL()
                .SELECT("ac.account_id, ac.account_name")
                .FROM("m_account ac")
                .LEFT_OUTER_JOIN("r_test_spec_account sa ON sa.account_id = ac.account_id AND sa.test_spec_id = #{testSpecId}")
                .LEFT_OUTER_JOIN("r_account_role ar ON ar.account_id = ac.account_id")
                .LEFT_OUTER_JOIN("m_role r ON r.role_id = ar.role_id AND r.role_type = #{approverType}")
                .toString()
        }
    }
}