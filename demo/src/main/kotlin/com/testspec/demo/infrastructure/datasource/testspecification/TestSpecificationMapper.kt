package com.testspec.demo.infrastructure.datasource.testspecification

import com.testspec.demo.domain.model.testspecification.TestSpecification
import com.testspec.demo.domain.model.testspecification.TestSpecifications
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select

@Mapper
interface TestSpecificationMapper {

    @Select("""
        SELECT *
        FROM m_test_specification
    """)

    fun findAll(): TestSpecifications
}