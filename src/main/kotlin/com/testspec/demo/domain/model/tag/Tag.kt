package com.testspec.demo.domain.model.tag

import com.testspec.demo.domain.model.tag.type.TagId
import com.testspec.demo.domain.model.tag.type.TagName
import com.testspec.demo.domain.model.testframe.testcase.type.TestCaseId
import com.testspec.demo.domain.model.testframe.testsuite.type.TestSuiteId
import com.testspec.demo.domain.model.testframe.type.Type

class Tag private constructor(
    val tagId: TagId,
    val tagName: TagName,
    val testSuiteId: TestSuiteId? = null,
    val testCaseId: TestCaseId? = null
) {

    companion object {
        fun create(tagId: Int, tagName: String, testSuiteId: Int? = null, testCaseId: Int? = null): Tag {
            return Tag(
                tagId = TagId(tagId),
                tagName = TagName(tagName),
                testSuiteId = testSuiteId?.let { TestSuiteId(it) },
                testCaseId = testCaseId?.let { TestCaseId(it) }
            )
        }
    }

    override fun toString(): String {
        return "tagId: ${this.tagId}, tagName: ${this.tagName}, testSuiteId: ${this.testSuiteId}, testCaseId: ${this.testCaseId}"
    }

}
