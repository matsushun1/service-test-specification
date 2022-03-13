package com.testspec.demo.domain.model.testcase

class TestTarget(
    private val target: String
) {
    fun value(): String = this.target
}