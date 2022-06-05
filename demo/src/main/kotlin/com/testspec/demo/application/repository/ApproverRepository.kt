package com.testspec.demo.application.repository

import com.testspec.demo.domain.model.account.approver.ApproverList
import org.springframework.stereotype.Repository

/**
 * 承認者リポジトリ
 */
@Repository
interface ApproverRepository {
    fun findByTestSpecId(testSpecId: Int): ApproverList
}