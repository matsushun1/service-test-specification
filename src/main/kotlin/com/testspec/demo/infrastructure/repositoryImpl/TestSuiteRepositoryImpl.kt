package com.testspec.demo.infrastructure.repositoryImpl

import com.Tables.M_TEST_FRAME
import com.Tables.R_TEST_FRAME_TAG
import com.testspec.demo.domain.model.testframe.testsuite.read.ReadTestSuite
import com.testspec.demo.domain.model.testframe.testsuite.read.TestSuiteQueryParam
import com.testspec.demo.domain.model.testframe.type.Type
import com.testspec.demo.domain.repository.testsuite.TestSuiteRepository
import org.jooq.DSLContext
import org.jooq.impl.DSL.arrayAgg
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class TestSuiteRepositoryImpl @Autowired constructor(
    val dsl: DSLContext
): TestSuiteRepository {

    override fun findAll(queryParam: TestSuiteQueryParam): List<ReadTestSuite> {
        val f = M_TEST_FRAME.`as`("f")
        val rt = R_TEST_FRAME_TAG.`as`("rt")
        val tagIdList = arrayAgg(rt.TAG_ID).`as`("tagIdList")
        val result = dsl.select(
            f.TEST_FRAME_ID,
            f.TITLE,
            f.EXPECTED,
            f.DESCRIPTION,
            f.PARENT_SUITE_ID,
            tagIdList
        )
            .from(f)
            .leftJoin(rt).on(rt.TEST_FRAME_ID.eq(f.TEST_FRAME_ID))
            .where(f.TYPE.eq(Type.TEST_SUITE.type))
            .groupBy(f.TEST_FRAME_ID)
            .orderBy(f.CREATED_AT)
            .limit(queryParam.limit)
            .fetch()
        return result.map {
            ReadTestSuite.create(
                testSuiteId = it.get(f.TEST_FRAME_ID),
                title = it.get(f.TITLE),
                expected = it.get(f.EXPECTED),
                description = it.get(f.DESCRIPTION),
                parentSuiteId = it.get(f.PARENT_SUITE_ID),
                tagIdList = it.get(tagIdList).mapNotNull { tagId -> tagId?.toInt() }
            )
        }
    }

}
