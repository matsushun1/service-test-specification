package com.testspec.demo.infrastructure.datasource.testspecification

import com.testspec.demo.application.repository.TestSpecificationRepository
import com.testspec.demo.domain.model.testspecification.TestSpecification
import com.testspec.demo.domain.model.testspecification.TestSpecifications
import com.testspec.demo.domain.model.testspecification.type.Keyword
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository
class TestSpecificationDataSource @Autowired constructor(
    val testSpecificationMapper: TestSpecificationMapper
): TestSpecificationRepository {
    override fun findAll(): TestSpecifications? {
        return testSpecificationMapper.findAll()
    }

    override fun search(keyword: Keyword, limit: Int): TestSpecifications {
        TODO("Not yet implemented")
    }

    override fun findOne(): TestSpecification {
        TODO("Not yet implemented")
    }
}