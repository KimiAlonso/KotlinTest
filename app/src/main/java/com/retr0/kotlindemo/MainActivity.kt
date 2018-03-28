package com.retr0.kotlindemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {


    val s: Int = 1

    override fun onClick(v: View) {

        when (v) {
            bt_test -> {
                Toast.makeText(this,"onclick",Toast.LENGTH_SHORT).show()
            }
            else -> {

            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()

    }

    private fun initView() {
        Toast.makeText(this,"initView",Toast.LENGTH_SHORT).show()
        bt_test.setOnClickListener(this)
    }
}
