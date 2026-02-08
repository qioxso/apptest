package com.example.simplejni

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var tvNumber: TextView
    private var currentNumber = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvNumber = findViewById(R.id.tv_number)
        val btnAdd: Button = findViewById(R.id.btn_add)

        // 初始化显示
        tvNumber.text = currentNumber.toString()

        btnAdd.setOnClickListener {
            // 调用 Native (C++) 函数
            currentNumber = nativeAdd(currentNumber)
            // 更新 UI
            tvNumber.text = currentNumber.toString()
        }
    }

    // 声明外部 native 方法
    external fun nativeAdd(value: Int): Int

    companion object {
        // 加载 'simplejni' 库 (对应 CMakeLists.txt 中的库名)
        init {
            System.loadLibrary("simplejni")
        }
    }
}
