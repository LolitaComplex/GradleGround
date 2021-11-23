package com.doing.aptapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.doing.router.apt.annotations.DoingRouter

@DoingRouter(url = "doing://APTRouter", description = "路由测试页面")
class APTRouterActivity : AppCompatActivity(), Comparator<Int> {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aptrouter)
    }

    override fun compare(p0: Int?, p1: Int?): Int {
        TODO("Not yet implemented")
    }
}