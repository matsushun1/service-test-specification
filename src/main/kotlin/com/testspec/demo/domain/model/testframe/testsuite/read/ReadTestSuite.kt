package com.testspec.demo.domain.model.testframe.testsuite.read

import com.testspec.demo.domain.model.testframe.Expected
import com.testspec.demo.domain.model.testframe.testsuite.type.ChildId
import com.testspec.demo.domain.model.testframe.testsuite.type.ParentSuiteId
import com.testspec.demo.domain.model.testframe.type.Description
import com.testspec.demo.domain.model.testframe.testsuite.type.TestSuiteId
import com.testspec.demo.domain.model.testframe.testsuite.type.Title

class ReadTestSuite private constructor(
  private val testSuiteId: TestSuiteId,
  private val title: Title,
  private val expected: Expected,
  private val description: Description,
  private val parentSuiteId: ParentSuiteId
) {

  companion object {
    fun create(testSuiteId: Int, title: String, expected: String, description: String, parentSuiteId: Int): ReadTestSuite {
      return ReadTestSuite(
        TestSuiteId(testSuiteId),
        Title(title),
        Expected(expected),
        Description(description),
        ParentSuiteId(parentSuiteId)
      )
    }
  }

  override fun toString(): String {
    return """
      testSuiteId: ${this.testSuiteId}, title: ${this.title}, expected: ${this.expected},
      description: ${this.description}, parentSuiteId: ${this.parentSuiteId}
    """.trimIndent()
  }

}
