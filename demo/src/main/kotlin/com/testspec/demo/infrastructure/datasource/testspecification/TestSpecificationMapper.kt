package com.testspec.demo.infrastructure.datasource.testspecification

import com.testspec.demo.domain.model.testspecification.TestSpecifications
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.SelectProvider
import org.apache.ibatis.builder.annotation.ProviderMethodResolver
import org.apache.ibatis.jdbc.SQL

@Mapper
interface TestSpecificationMapper {

    @SelectProvider(TestSpecificationProvider::class)
    fun findAll(): TestSpecifications?

    class TestSpecificationProvider: ProviderMethodResolver {
        fun findAll(): String {
            return SQL()
                .SELECT("test_specification_id, title, test_supplement, tested_dt")
                .FROM("m_test_specification")
                .ORDER_BY("tested_dt")
                .toString()
        }
    }


}