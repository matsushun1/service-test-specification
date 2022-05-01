package com.testspec.demo.application.service

import com.testspec.demo.application.repository.TestSpecRepository
import com.testspec.demo.domain.model.testspecification.TestSpecList
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * テスト仕様書のサービスクラス
 */
@Service
class TestSpecService @Autowired constructor(
    val testSpecRepository: TestSpecRepository
) {

    fun findAll(): TestSpecList {
        return testSpecRepository.findAll()
    }

}
