package com.testspec.demo.domain.repository

import com.testspec.demo.domain.model.testspec.read.ReadTestSpec
import org.springframework.stereotype.Repository

@Repository
interface TestSpecRepository {

    fun findAll(): List<ReadTestSpec>

}
