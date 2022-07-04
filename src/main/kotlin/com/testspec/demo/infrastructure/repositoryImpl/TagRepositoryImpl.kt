package com.testspec.demo.infrastructure.repositoryImpl

import com.Tables.M_TAG
import com.testspec.demo.domain.model.tag.Tag
import com.testspec.demo.domain.repository.tag.TagRepository
import org.jooq.DSLContext
import org.springframework.beans.factory.annotation.Autowired

class TagRepositoryImpl @Autowired constructor(
    val dsl: DSLContext
): TagRepository {

    override fun findAll(): List<Tag> {
        val result = dsl.select()
            .from(M_TAG)
            .orderBy(M_TAG.CREATED_AT)
        return result.map {
            Tag.create(tagId = it.get(M_TAG.TAG_ID), tagName = it.get(M_TAG.TAG_NAME))
        }
    }

}
