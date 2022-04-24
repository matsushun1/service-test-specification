package com.testspec.demo.application.service

import com.testspec.demo.application.repository.TestSpecificationRepository
import com.testspec.demo.domain.model.testspecification.TestSpecifications
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * テスト仕様書のサービスクラス
 */
@Service
class TestSpecificationService @Autowired constructor(
    val testSpecificationRepository: TestSpecificationRepository
) {

    fun findAll(): TestSpecifications? {
        return testSpecificationRepository.findAll()
    }
}