package com.testspec.demo.domain.model.tag

import com.testspec.demo.domain.model.tag.type.TagId
import com.testspec.demo.domain.model.tag.type.TagName

class Tag private constructor(
    private val tagId: TagId,
    private val tagName: TagName
) {

    companion object {
        fun create(tagId: Int, tagName: String): Tag {
            return Tag(TagId(tagId), TagName(tagName))
        }
    }

    override fun toString(): String {
        return "tagId: ${this.tagId}, tagName: ${this.tagName}"
    }

}
