package com.testspec.demo.infrastructure.datasource.testspecification

import com.testspec.demo.domain.model.testspecification.TestSpec
import org.apache.ibatis.annotations.*
import org.apache.ibatis.jdbc.SQL

@Mapper
interface TestSpecificationMapper {
    fun findAll(): List<TestSpec>
}