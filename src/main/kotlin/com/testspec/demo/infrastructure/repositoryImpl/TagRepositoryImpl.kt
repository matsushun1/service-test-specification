package com.testspec.demo.infrastructure.repositoryImpl

import com.Tables.M_TAG
import com.Tables.R_TEST_FRAME_TAG
import com.testspec.demo.domain.model.tag.Tag
import com.testspec.demo.domain.model.tag.type.queryparam.TagQueryParam
import com.testspec.demo.domain.model.testframe.type.Type
import com.testspec.demo.domain.repository.tag.TagRepository
import org.jooq.DSLContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TagRepositoryImpl @Autowired constructor(
    val dsl: DSLContext
): TagRepository {

    override fun findAll(): List<Tag> {
        val result = dsl.select(M_TAG.TAG_ID, M_TAG.TAG_NAME)
            .from(M_TAG)
            .orderBy(M_TAG.CREATED_AT)
        return result.map {
            Tag.create(tagId = it.get(M_TAG.TAG_ID), tagName = it.get(M_TAG.TAG_NAME))
        }
    }

    override fun findBy(queryParam: TagQueryParam): List<Tag> {
        val result = dsl.select(M_TAG.TAG_ID, M_TAG.TAG_NAME, R_TEST_FRAME_TAG.TEST_FRAME_ID)
            .from(M_TAG)
            .leftJoin(R_TEST_FRAME_TAG).on(R_TEST_FRAME_TAG.TAG_ID.eq(M_TAG.TAG_ID))
            .where(queryParam.testSuiteIdList.let { R_TEST_FRAME_TAG.TEST_FRAME_ID.`in`(it) })
            .orderBy(M_TAG.CREATED_AT)
        return result.map {
            Tag.create(tagId = it.get(M_TAG.TAG_ID), tagName = it.get(M_TAG.TAG_NAME), testSuiteId = it.get(R_TEST_FRAME_TAG.TEST_FRAME_ID))
        }
    }

}
