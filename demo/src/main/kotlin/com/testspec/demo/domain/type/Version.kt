package com.testspec.demo.domain.type

/**
 * テスト対象のソフトウェアバージョン
 */
class Version(
    private val version: String
) {
    fun version(): String = this.version
}