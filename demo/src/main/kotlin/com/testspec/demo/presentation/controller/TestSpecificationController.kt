package com.testspec.demo.presentation.controller

import com.testspec.demo.application.service.TestSpecService
import com.testspec.demo.domain.model.testspecification.TestSpecList
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * テスト仕様書のコントローラクラス
 */
@RestController
@RequestMapping("/testSpec")
class TestSpecController @Autowired constructor(
    val testSpecService: TestSpecService
) {

    @GetMapping("/all")
    fun findAll(): TestSpecList? {
        return testSpecService.findAll()
    }

}
