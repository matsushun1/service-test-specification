package com.testspec.demo.presentation.controller

import com.testspec.demo.application.service.ApproverService
import com.testspec.demo.domain.model.account.approver.ApproverList
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/approver")
class ApproverController @Autowired constructor(
    val approverService: ApproverService
) {

    @GetMapping("/findByTestSpecId/{testSpecId}")
    fun findByTestSpecId(@PathVariable("testSpecId") testSpecId: Int): ApproverList {
        return approverService.findByTestSpecId(testSpecId)
    }
}
