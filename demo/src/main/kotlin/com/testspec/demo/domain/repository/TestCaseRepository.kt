package com.testspec.demo.domain.repository

import com.testspec.demo.domain.model.testcase.read.ReadTestCase
import org.springframework.stereotype.Repository

@Repository
interface TestCaseRepository {

    fun findAll(): List<ReadTestCase>
}
