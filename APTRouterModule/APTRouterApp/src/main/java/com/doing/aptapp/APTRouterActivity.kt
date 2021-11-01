package com.doing.aptapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.doing.router.apt.annotations.DoingRouter

@DoingRouter(url = "doing://APTRouter", description = "路由测试页面")
class APTRouterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aptrouter)
    }
}