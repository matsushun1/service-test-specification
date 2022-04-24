package com.testspec.demo.presentation.controller

import com.testspec.demo.application.service.TestSpecificationService
import com.testspec.demo.domain.model.testspecification.TestSpecifications
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * テスト仕様書のコントローラクラス
 */
@RestController
@RequestMapping("/testSpec")
class TestSpecificationController @Autowired constructor(
    val testSpecificationService: TestSpecificationService
) {

    @GetMapping("/all")
    fun findAll(): TestSpecifications? {
        return testSpecificationService.findAll()
    }
}