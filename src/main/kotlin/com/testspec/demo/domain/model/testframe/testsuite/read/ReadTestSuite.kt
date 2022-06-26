package com.testspec.demo.domain.model.testframe.testsuite.read

import com.testspec.demo.domain.model.testframe.Expected
import com.testspec.demo.domain.model.testframe.testsuite.type.ChildId
import com.testspec.demo.domain.model.testframe.type.Description
import com.testspec.demo.domain.model.testframe.testsuite.type.TestSuiteId
import com.testspec.demo.domain.model.testframe.testsuite.type.Title

class ReadTestSuite private constructor(
  private val testSuiteId: TestSuiteId,
  private val title: Title,
  private val expected: Expected,
  private val description: Description,
  private val parentSuiteId: TestSuiteId,
  private val childrenIdList: List<ChildId> // TODO: ファーストクラスコレクションの実装を検討
) {

  fun create(testSuiteId: Int, title: String, expected: String, description: String, parentSuiteId: Int, childrenIdList: List<Int>): ReadTestSuite {
    return ReadTestSuite(
      TestSuiteId(testSuiteId),
      Title(title),
      Expected(expected),
      Description(description),
      TestSuiteId(parentSuiteId),
      childrenIdList.map { ChildId(it) }
    )
  }

}
