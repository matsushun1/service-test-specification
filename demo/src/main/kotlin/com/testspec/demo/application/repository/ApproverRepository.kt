package com.testspec.demo.application.repository

import com.testspec.demo.domain.model.account.approver.ApproverList

/**
 * 承認者リポジトリ
 */
interface ApproverRepository {
    fun findByTestSpecId(testSpecId: Int): ApproverList
}