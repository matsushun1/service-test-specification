package com.testspec.demo.domain.exception

class DomainException(msg: String = "Domain Error", cause: Throwable): Exception(msg, cause) {

}
