package com.example.tp_05_mvvm.activity // ktlint-disable package-name

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tp_05_mvvm.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
