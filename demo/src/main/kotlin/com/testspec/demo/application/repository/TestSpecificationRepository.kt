package com.testspec.demo.application.repository

import com.testspec.demo.domain.model.testspecification.TestSpecification
import com.testspec.demo.domain.model.testspecification.TestSpecifications
import com.testspec.demo.domain.model.testspecification.type.Keyword

/**
 * テスト仕様書リポジトリ
 */
interface TestSpecificationRepository {
    fun findAll(): TestSpecifications?

    fun search(keyword: Keyword, limit: Int): TestSpecifications

    fun findOne(): TestSpecification
}