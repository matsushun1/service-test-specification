package com.testspec.demo.infrastructure.datasource.approver

import com.testspec.demo.application.repository.ApproverRepository
import com.testspec.demo.domain.model.account.approver.ApproverList
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository
class ApproverDataSource @Autowired constructor(
    val approverMapper: ApproverMapper
): ApproverRepository {

    override fun findByTestSpecId(testSpecId: Int): ApproverList {
        val approverList = approverMapper.findByTestSpecId(testSpecId)
        return ApproverList(approverList)
    }

}
