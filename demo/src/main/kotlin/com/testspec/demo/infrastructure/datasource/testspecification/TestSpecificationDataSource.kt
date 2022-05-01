package com.testspec.demo.infrastructure.datasource.testspecification

import com.testspec.demo.application.repository.TestSpecRepository
import com.testspec.demo.domain.model.testspecification.TestSpec
import com.testspec.demo.domain.model.testspecification.TestSpecList
import com.testspec.demo.domain.model.testspecification.type.Keyword
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository
class TestSpecDataSource @Autowired constructor(
    val testSpecificationMapper: TestSpecificationMapper
): TestSpecRepository {

    override fun findAll(): TestSpecList {
        val testSpecList = testSpecificationMapper.findAll()
        return TestSpecList(testSpecList)
    }

    override fun search(keyword: Keyword, limit: Int): TestSpecList {
        TODO("Not yet implemented")
    }

    override fun findOne(): TestSpec {
        TODO("Not yet implemented")
    }
}
