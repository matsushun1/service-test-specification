package com.testspec.demo.application.service

import com.testspec.demo.application.repository.ApproverRepository
import com.testspec.demo.domain.model.account.approver.ApproverList
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ApproverService @Autowired constructor(
    val approverRepository: ApproverRepository
) {

    fun findByTestSpecId(testSpecId: Int): ApproverList {
        return approverRepository.findByTestSpecId(testSpecId)
    }

}
