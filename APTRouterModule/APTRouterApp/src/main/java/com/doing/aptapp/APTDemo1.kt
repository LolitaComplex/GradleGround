package com.doing.aptapp

import com.doing.router.apt.annotations.DoingRouter

@DoingRouter(url = "doing://entity", description = "demo1")
class APTDemo1(private val name: String) {

    fun setName() {

    }
}