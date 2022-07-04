package com.testspec.demo.domain.repository.tag

import com.testspec.demo.domain.model.tag.Tag
import org.springframework.stereotype.Repository

@Repository
interface TagRepository {

    fun findAll(): List<Tag>

}
