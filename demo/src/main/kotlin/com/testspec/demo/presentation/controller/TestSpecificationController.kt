package com.testspec.demo.presentation.controller

import com.testspec.demo.application.service.TestSpecificationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller

/**
 * テスト仕様書のコントローラクラス
 */
@Controller
class TestSpecificationController @Autowired constructor(
    val testSpecificationService: TestSpecificationService
) {
}