package com.testspec.demo.infrastructure.datasource.testspecification

import com.testspec.demo.domain.model.testspecification.TestSpec
import org.apache.ibatis.annotations.*
import org.apache.ibatis.jdbc.SQL

@Mapper
interface TestSpecificationMapper {

    @Results(id = "findTestSpecAll", value = [
        Result(column = "test_spec_id", property = "testSpecId"),
        Result(column = "title", property = "title"),
        Result(column = "tested_dt", property = "testedDt"),
        Result(column = "test_supplement", property = "testSupplement"),
        Result(column = "test_spec_id", property = "approverList", javaType = List::class, many = Many(select = "com.testspec.demo.infrastructure.datasource.approver.ApproverMapper.findByTestSpecId"))
    ])
    @SelectProvider(type = TestSpecificationProvider::class, method = "findAll")
    fun findAll(): List<TestSpec>

    class TestSpecificationProvider {
        fun findAll(): String {
            return SQL()
                .SELECT("ts.test_spec_id, ts.title, ts.test_supplement, ts.tested_dt")
                .FROM("m_test_spec ts")
                .ORDER_BY("ts.tested_dt")
                .toString()
        }
    }


}