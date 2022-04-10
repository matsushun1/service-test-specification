package com.testspec.demo.application.repository

import com.testspec.demo.domain.model.testspecification.TestSpecification
import com.testspec.demo.domain.model.testspecification.TestSpecifications

/**
 * テスト仕様書リポジトリ
 */
interface TestSpecificationRepository {
    fun findAll(): TestSpecifications

    fun search(): TestSpecifications

    fun findOne(): TestSpecification
}