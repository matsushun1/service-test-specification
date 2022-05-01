package com.testspec.demo.infrastructure.datasource.testspecification

import com.testspec.demo.domain.model.testspecification.TestSpec
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.SelectProvider
import org.apache.ibatis.jdbc.SQL

@Mapper
interface TestSpecificationMapper {

    @SelectProvider(type = TestSpecificationProvider::class, method = "findAll")
    fun findAll(): List<TestSpec>

    class TestSpecificationProvider {
        fun findAll(): String {
            return SQL()
                .SELECT("test_spec_id, title, test_supplement, tested_dt")
                .FROM("m_test_spec ts")
                .LEFT_OUTER_JOIN("r_test_spec_account ta ON ta.test_spec_Id = ts.test_spec_Id")
                .LEFT_OUTER_JOIN("m_account ac ON ac.account_id = ta.account_id")
                .LEFT_OUTER_JOIN("")
                .ORDER_BY("tested_dt")
                .toString()
        }
    }


}