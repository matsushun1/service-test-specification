package com.testspec.demo.domain.model.testframe.testsuite.read

import com.fasterxml.jackson.annotation.JsonUnwrapped
import com.testspec.demo.domain.model.tag.Tag
import com.testspec.demo.domain.model.testframe.Expected
import com.testspec.demo.domain.model.testframe.testsuite.type.ParentSuiteId
import com.testspec.demo.domain.model.testframe.testsuite.type.TestSuiteId
import com.testspec.demo.domain.model.testframe.testsuite.type.Title
import com.testspec.demo.domain.model.testframe.type.Description
import java.io.Serializable

class ReadTestSuiteWithTags private constructor(
    @JsonUnwrapped val testSuiteId: TestSuiteId,
    @JsonUnwrapped val title: Title,
    @JsonUnwrapped val expected: Expected,
    @JsonUnwrapped val description: Description? = null,
    @JsonUnwrapped val parentSuiteId: ParentSuiteId? = null,
    @JsonUnwrapped val tagList: List<Tag>? = null
): Serializable {

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
