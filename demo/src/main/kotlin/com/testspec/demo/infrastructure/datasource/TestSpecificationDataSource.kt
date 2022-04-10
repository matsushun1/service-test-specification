package com.testspec.demo.infrastructure.datasource

import com.testspec.demo.application.repository.TestSpecificationRepository
import com.testspec.demo.domain.model.testspecification.TestSpecification
import com.testspec.demo.domain.model.testspecification.TestSpecifications
import org.springframework.stereotype.Repository

@Repository
class TestSpecificationDataSource: TestSpecificationRepository {
    override fun findAll(): TestSpecifications {
        TODO("Not yet implemented")
    }

    override fun search(): TestSpecifications {
        TODO("Not yet implemented")
    }

    override fun findOne(): TestSpecification {
        TODO("Not yet implemented")
    }
}