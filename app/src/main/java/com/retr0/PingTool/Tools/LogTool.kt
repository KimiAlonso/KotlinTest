package com.retr0.PingTool.Tools

import android.util.Log

/**
 * Created by Retr0 on 2018/3/29 0029.
 */
class LogTool {
    companion object {
        var isOpen = true

        fun logE (Tag : String , Msg : String){
            if (isOpen){
                Log.e(Tag,Msg)
            }
        }
    }
}