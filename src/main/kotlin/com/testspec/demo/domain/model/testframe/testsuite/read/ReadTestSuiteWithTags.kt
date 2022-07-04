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
    private val description: Description?,
    private val parentSuiteId: ParentSuiteId?,
    private val tagList: List<Tag>?
) {

    companion object {
        fun create(testSuiteId: Int, title: String, expected: String, description: String?, parentSuiteId: Int?, tagList: List<Tag>?): ReadTestSuiteWithTags {
            return ReadTestSuiteWithTags (
                TestSuiteId(testSuiteId),
                Title(title),
                Expected(expected),
                description?.let { Description(it) },
                parentSuiteId?.let { ParentSuiteId(it) },
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
