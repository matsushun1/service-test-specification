package com.testspec.demo.infrastructure.datasource.testspecification

import com.testspec.demo.domain.model.testspecification.TestSpecification
import com.testspec.demo.domain.model.testspecification.TestSpecifications
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.SelectProvider
import org.apache.ibatis.builder.annotation.ProviderMethodResolver
import org.apache.ibatis.jdbc.SQL

@Mapper
interface TestSpecificationMapper {

    @SelectProvider(type = TestSpecificationProvider::class, method = "findAll")
    fun findAll(): List<TestSpecification>

    class TestSpecificationProvider {
        fun findAll(): String {
            return SQL()
                .SELECT("test_specification_id, title, test_supplement, tested_dt")
                .FROM("m_test_specification ts")
                .LEFT_OUTER_JOIN("r_test_specification_account ta ON ta.test_specification_Id = ts.test_specification_Id")
                .LEFT_OUTER_JOIN("account ac ON ac.account_id = ta.account_id")
                .LEFT_OUTER_JOIN("")
                .ORDER_BY("tested_dt")
                .toString()
        }
    }


}