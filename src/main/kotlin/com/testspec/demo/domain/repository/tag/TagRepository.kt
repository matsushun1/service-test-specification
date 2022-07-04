package com.testspec.demo.domain.repository.tag

import com.testspec.demo.domain.model.tag.Tag
import com.testspec.demo.domain.model.tag.type.queryparam.TagQueryParam
import org.springframework.stereotype.Repository

@Repository
interface TagRepository {

    fun findAll(): List<Tag>

    fun findBy(queryParam: TagQueryParam): List<Tag>

}
