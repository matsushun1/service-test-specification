package com.testspec.demo.domain.model.testframe.testsuite.read

import com.testspec.demo.domain.model.tag.type.TagId
import com.testspec.demo.domain.model.testframe.Expected
import com.testspec.demo.domain.model.testframe.testsuite.type.ParentSuiteId
import com.testspec.demo.domain.model.testframe.type.Description
import com.testspec.demo.domain.model.testframe.testsuite.type.TestSuiteId
import com.testspec.demo.domain.model.testframe.testsuite.type.Title

class ReadTestSuite private constructor(
  private val testSuiteId: TestSuiteId,
  private val title: Title,
  private val expected: Expected,
  private val description: Description? = null,
  private val parentSuiteId: ParentSuiteId? = null,
  private val tagIdList: List<TagId>? = null
) {

  companion object {
    fun create(testSuiteId: Int, title: String, expected: String, description: String?, parentSuiteId: Int?, tagIdList: List<Int>?): ReadTestSuite {
      return ReadTestSuite(
        TestSuiteId(testSuiteId),
        Title(title),
        Expected(expected),
        description?.let { Description(it) },
        parentSuiteId?.let { ParentSuiteId(it) },
        tagIdList?.map { TagId(it) }
      )
    }
  }

  override fun toString(): String {
    return """
      testSuiteId: ${this.testSuiteId}, title: ${this.title}, expected: ${this.expected},
      description: ${this.description}, parentSuiteId: ${this.parentSuiteId}}, tagIdList: ${this.tagIdList}
    """.trimIndent()
  }

}
