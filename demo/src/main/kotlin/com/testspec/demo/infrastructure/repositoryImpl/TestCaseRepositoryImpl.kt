package com.testspec.demo.infrastructure.repositoryImpl

import com.Tables.M_TEST_CASE
import com.testspec.demo.domain.model.testcase.read.ReadTestCase
import com.testspec.demo.domain.repository.TestCaseRepository
import org.jooq.DSLContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class TestCaseRepositoryImpl @Autowired constructor(
    val dsl: DSLContext
): TestCaseRepository {

    override fun findAll(): List<ReadTestCase> {
        val result = dsl.select()
            .from(M_TEST_CASE)
            .orderBy(M_TEST_CASE.CREATED_AT)
        return result.map {
            ReadTestCase.create(
                testCaseId = it.get(M_TEST_CASE.TEST_CASE_ID),
                target = it.get(M_TEST_CASE.TARGET),
                expected = it.get(M_TEST_CASE.EXPECTED),
                testSupplement = it.get(M_TEST_CASE.DESCRIPTION)
            )
        }
    }

}
