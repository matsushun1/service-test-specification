package com.testspec.demo.application.usecase.testsuite

import com.testspec.demo.domain.model.tag.type.queryparam.TagQueryParam
import com.testspec.demo.domain.model.testframe.testsuite.read.ReadTestSuiteWithTags
import com.testspec.demo.domain.model.testframe.testsuite.read.TestSuiteQueryParam
import com.testspec.demo.infrastructure.repositoryImpl.TagRepositoryImpl
import com.testspec.demo.infrastructure.repositoryImpl.TestSuiteRepositoryImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ReadTestSuiteUseCase @Autowired constructor(
    val testSuiteRepositoryImpl: TestSuiteRepositoryImpl,
    val tagRepositoryImpl: TagRepositoryImpl
) {

    fun findAllWithTags(queryParam: TestSuiteQueryParam): List<ReadTestSuiteWithTags> {
        val testSuiteList = testSuiteRepositoryImpl.findAll(queryParam)
        val testSuiteIdTagListMap = tagRepositoryImpl.findBy(TagQueryParam(testSuiteList.map { it.testSuiteId }))
            .groupBy { it.testSuiteId?.value }
        return testSuiteList.map {
            ReadTestSuiteWithTags.create(
                testSuiteId = it.testSuiteId,
                title = it.title,
                expected = it.expected,
                description = it.description,
                parentSuiteId = it.parentSuiteId,
                tagList = testSuiteIdTagListMap[it.testSuiteId.value]
            )
        }
    }

}
