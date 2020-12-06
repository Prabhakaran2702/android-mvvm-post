package com.example.justclean_mvvm_post.utils

import android.content.Context
import android.net.ConnectivityManager

class Util {

    companion object {

        fun isNetworkConnected(mContext: Context): Boolean {
            val cm = mContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            return cm.activeNetworkInfo != null && cm.activeNetworkInfo!!.isConnected
        }

    }


}