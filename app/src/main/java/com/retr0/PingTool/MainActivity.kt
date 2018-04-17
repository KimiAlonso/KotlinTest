package com.retr0.PingTool

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.retr0.PingTool.Tools.LogTool
import io.reactivex.*
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.rxkotlin.toObservable
import kotlinx.android.synthetic.main.activity_main.*
import java.io.BufferedReader
import java.io.InputStream
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.internal.operators.observable.ObservableCreate
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity(), View.OnClickListener {


    val s: Int = 1
    var address = "www.baidu.com"
    var pingMsg = " "
    var colorCode = " "

    override fun onClick(v: View) {
        when (v) {
            bt_test -> {
                colorCode = tv_address.text.toString()
//                iv_color.setBackgroundColor(Integer.parseInt(colorCode))


                LogTool.logE("color",colorCode)
//                Toast.makeText(this, "onclick", Toast.LENGTH_SHORT).show()
//                Thread({
//                    val process: Process = Runtime.getRuntime().exec("ping " + address)
//                    val imput: InputStream = process.inputStream
//                    val bufferReader: BufferedReader = imput.bufferedReader()
//                    var msg: String = bufferReader.readLine()
//                    while (msg != null) {
//                        Log.e("ping", msg)
//                        msg = bufferReader.readLine()
//                    }
//                }).start()

//                val intent = Intent(this,ScanActivity::class.java)
//                startActivity(intent)


            }
            else -> {
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()


        val observer: Observer<Any> = object : Observer<Any> {
            override fun onComplete() {
                println("All Completed")
                LogTool.logE("onComplete", "All Completed")
            }

            override fun onNext(item: Any) {
                println("Next $item")
                LogTool.logE("onNext","go")
                LogTool.logE("onNext", pingMsg)
                Toast.makeText(this@MainActivity, pingMsg, Toast.LENGTH_SHORT).show()
                tv_pingMsg.setText(pingMsg)

            }

            override fun onError(e: Throwable) {
                println("Error Occured ${e.message}")
            }

            override fun onSubscribe(d: Disposable) {
                LogTool.logE("onSubcribe", "New Subscription")
                println("New Subscription ")
            }
        }

        val observable: Observable<Int> = Observable.create<Int> {

//          子线程耗时操作
//            while (true) {
//                pingMsg = pingMsg + "1"
//                Thread.sleep(2000)
//                it.onNext(1)
//
//            }

            it.onComplete()
        }

        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer)

    }

    private fun initView() {
        Toast.makeText(this, "initView", Toast.LENGTH_SHORT).show()
        address = tv_address.text.toString()
        bt_test.setOnClickListener(this)
    }


}
