package com.testspec.demo.application.repository

import com.testspec.demo.domain.model.account.tester.TesterList


/**
 * テスターリポジトリ
 */
interface TesterRepository {

    fun findByTestSpecId(testSpecId: Int): TesterList

}
