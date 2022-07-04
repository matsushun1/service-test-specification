package com.testspec.demo.domain.repository.testcase

import com.testspec.demo.domain.model.testframe.testcase.read.ReadTestCase
import org.springframework.stereotype.Repository

@Repository
interface TestCaseRepository {

    fun findAll(): List<ReadTestCase>
}
