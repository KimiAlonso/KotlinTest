package com.retr0.PingTool

import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.retr0.PingTool.R
import kotlinx.android.synthetic.main.activity_main.*
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.io.LineNumberReader

class MainActivity : AppCompatActivity(), View.OnClickListener {


    val s: Int = 1
    val address = "8.8.8.8"

    override fun onClick(v: View) {
        when (v) {
            bt_test -> {
                Toast.makeText(this,"onclick",Toast.LENGTH_SHORT).show()
                Thread({
                    val process : Process = Runtime.getRuntime().exec("ping "+address)
                    val imput : InputStream = process.inputStream
                    val bufferReader : BufferedReader = imput.bufferedReader()
                    var msg : String= bufferReader.readLine()
                    while ( msg != null){
                        Log.e("ping",msg)
                        msg = bufferReader.readLine()
                    }
                }).start()
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
