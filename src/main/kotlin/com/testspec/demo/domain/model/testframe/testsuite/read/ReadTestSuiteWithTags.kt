package com.testspec.demo.domain.model.testframe.testsuite.read

import com.testspec.demo.domain.model.tag.Tag
import com.testspec.demo.domain.model.testframe.Expected
import com.testspec.demo.domain.model.testframe.testsuite.type.ParentSuiteId
import com.testspec.demo.domain.model.testframe.testsuite.type.TestSuiteId
import com.testspec.demo.domain.model.testframe.testsuite.type.Title
import com.testspec.demo.domain.model.testframe.type.Description

class ReadTestSuiteWithTags private constructor(
    private val testSuiteId: TestSuiteId,
    private val title: Title,
    private val expected: Expected,
    private val description: Description? = null,
    private val parentSuiteId: ParentSuiteId? = null,
    private val tagList: List<Tag>? = null
) {

    companion object {
        fun create(testSuiteId: TestSuiteId, title: Title, expected: Expected, description: Description?, parentSuiteId: ParentSuiteId?, tagList: List<Tag>?): ReadTestSuiteWithTags {
            return ReadTestSuiteWithTags (
                testSuiteId,
                title,
                expected,
                description,
                parentSuiteId,
                tagList
            )
        }
    }

    override fun toString(): String {
        return """
      testSuiteId: ${this.testSuiteId}, title: ${this.title}, expected: ${this.expected},
      description: ${this.description}, parentSuiteId: ${this.parentSuiteId}, tagList: ${this.tagList?.joinToString(",")}
    """.trimIndent()
    }
}
