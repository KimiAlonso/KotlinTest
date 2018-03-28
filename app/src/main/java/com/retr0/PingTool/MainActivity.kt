package com.retr0.PingTool

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import io.reactivex.*
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.rxkotlin.toObservable
import kotlinx.android.synthetic.main.activity_main.*
import java.io.BufferedReader
import java.io.InputStream

class MainActivity : AppCompatActivity(), View.OnClickListener {


    val s: Int = 1
    var address = "8.8.8.8"

    override fun onClick(v: View) {
        when (v) {
            bt_test -> {
                Toast.makeText(this, "onclick", Toast.LENGTH_SHORT).show()
                Thread({
                    val process: Process = Runtime.getRuntime().exec("ping " + address)
                    val imput: InputStream = process.inputStream
                    val bufferReader: BufferedReader = imput.bufferedReader()
                    var msg: String = bufferReader.readLine()
                    while (msg != null) {
                        Log.e("ping", msg)
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

        val list: List<Any> = listOf("One", 2, "Three", "Four", 4.5, "Five", 6.0f)
        val observable: Observable<Any> = list.toObservable()

        observable.subscribeBy(
                onNext = { println(it) },
                onError = { it.printStackTrace() },
                onComplete = { println("Done!") }
        )


        val maybeValue: Maybe<Int> = Maybe.just(14)
        maybeValue.subscribeBy(
                onComplete = { println("Completed Empty") },
                onError = { println("Error $it") },
                onSuccess = { println("Completed with value $it") }
        )


//        Observable.fromArray(listOf(1,2,3,4,5))
//
//        Observable.create(object : ObservableOnSubscribe<Int> {
//            override fun subscribe(e: ObservableEmitter<Int>) {
//
//            }
//
//        })
//
////        var observable = Observable.create(object : ObservableOnSubscribe<Int> {
////            override fun subscribe(e: ObservableEmitter<Int>) {
////
////            }
////        })
//
//        Observable.create(object : ObservableOnSubscribe<Int>{
//            override fun subscribe(e: ObservableEmitter<Int>) {
//
//            }
//        }).subscribe(Observer<Int>{
//
//        })


//        Observable.just("hi").subscribeOn(AndroidSchedulers.mainThread()).subscribe(observable)


    }

    private fun initView() {
        Toast.makeText(this, "initView", Toast.LENGTH_SHORT).show()
        address = tv_address.text.toString()
        bt_test.setOnClickListener(this)
    }


}
