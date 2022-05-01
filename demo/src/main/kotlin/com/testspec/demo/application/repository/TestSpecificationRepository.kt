package com.testspec.demo.application.repository

import com.testspec.demo.domain.model.testspecification.TestSpec
import com.testspec.demo.domain.model.testspecification.TestSpecList
import com.testspec.demo.domain.model.testspecification.type.Keyword

/**
 * テスト仕様書リポジトリ
 */
interface TestSpecRepository {
    fun findAll(): TestSpecList

    fun search(keyword: Keyword, limit: Int): TestSpecList

    fun findOne(): TestSpec
}