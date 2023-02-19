package com.testspec.demo.infrastructure.repositoryImpl

import com.Tables.M_TEST_FRAME
import com.testspec.demo.domain.model.testframe.testcase.TestCase
import com.testspec.demo.domain.model.testframe.testcase.TestCaseQueryParam
import com.testspec.demo.domain.model.testframe.type.Type
import com.testspec.demo.domain.repository.testcase.TestCaseRepository
import org.jooq.DSLContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class TestCaseRepositoryImpl @Autowired constructor(
    val dsl: DSLContext
): TestCaseRepository {

    override fun findAll(queryParam: TestCaseQueryParam): List<TestCase> {
        val f = M_TEST_FRAME.`as`("f")
        val result = dsl.select(f.TEST_FRAME_ID, f.TARGET, f.EXPECTED, f.EXPECTED, f.DESCRIPTION, f.STATUS, f.PARENT_SUITE_ID)
            .from(f)
            .where(f.TYPE.eq(Type.TEST_CASE.ordinal))
            .orderBy(f.CREATED_AT)
            .limit(queryParam.limit)
        return result.map {
            TestCase.create(
                testCaseId = it.get(f.TEST_FRAME_ID),
                target = it.get(f.TARGET),
                expected = it.get(f.EXPECTED),
                description = it.get(f.DESCRIPTION),
                status = it.get(f.STATUS),
                parentSuiteId = it.get(f.PARENT_SUITE_ID)
            )
        }
    }

}
