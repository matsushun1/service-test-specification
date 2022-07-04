package com.testspec.demo.infrastructure.repositoryImpl

import com.Tables.M_TEST_FRAME
import com.testspec.demo.domain.model.testframe.testcase.read.ReadTestCase
import com.testspec.demo.domain.model.testframe.type.Type
import com.testspec.demo.domain.repository.testcase.TestCaseRepository
import org.jooq.DSLContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class TestCaseRepositoryImpl @Autowired constructor(
    val dsl: DSLContext
): TestCaseRepository {

    override fun findAll(): List<ReadTestCase> {
        val result = dsl.select()
            .from(M_TEST_FRAME)
            .where(M_TEST_FRAME.TYPE.eq(Type.TEST_CASE.ordinal))
            .orderBy(M_TEST_FRAME.CREATED_AT)
        return result.map {
            ReadTestCase.create(
                testCaseId = it.get(M_TEST_FRAME.TEST_FRAME_ID),
                target = it.get(M_TEST_FRAME.TARGET),
                expected = it.get(M_TEST_FRAME.EXPECTED),
                description = it.get(M_TEST_FRAME.DESCRIPTION),
                status = it.get(M_TEST_FRAME.STATUS),
                parentSuiteId = it.get(M_TEST_FRAME.PARENT_SUITE_ID)
            )
        }
    }

}
