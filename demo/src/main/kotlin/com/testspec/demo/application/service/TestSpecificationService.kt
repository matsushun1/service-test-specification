package com.testspec.demo.application.service

import com.testspec.demo.domain.model.testspecification.TestSpecification
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * テスト仕様書のサービスクラス
 */
@Service
class TestSpecificationService @Autowired constructor(
    val testSpecification: TestSpecification
) {
}