package com.testspec.demo.infrastructure.repositoryImpl

import com.Tables.M_TEST_FRAME
import com.testspec.demo.domain.model.testframe.testsuite.read.ReadTestSuite
import com.testspec.demo.domain.model.testframe.testsuite.read.TestSuiteQueryParam
import com.testspec.demo.domain.model.testframe.type.Type
import com.testspec.demo.domain.repository.TestSuiteRepository
import org.jooq.DSLContext
import org.jooq.impl.DSL.name
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class TestSuiteRepositoryImpl @Autowired constructor(
    val dsl: DSLContext
): TestSuiteRepository {

    override fun findAll(queryParam: TestSuiteQueryParam): List<ReadTestSuite> {
        val result = dsl.select()
            .from(M_TEST_FRAME)
            .where(M_TEST_FRAME.TYPE.eq(Type.TEST_SUITE.ordinal))
            .orderBy(M_TEST_FRAME.CREATED_AT)
            .limit(queryParam.limit.value)
        return result.map {
            ReadTestSuite.create(
                testSuiteId = it.get(M_TEST_FRAME.TEST_FRAME_ID),
                title = it.get(M_TEST_FRAME.TITLE),
                expected = it.get(M_TEST_FRAME.EXPECTED),
                description = it.get(M_TEST_FRAME.DESCRIPTION),
                parentSuiteId = it.get(M_TEST_FRAME.PARENT_SUITE_ID)
            )
        }
    }

}
