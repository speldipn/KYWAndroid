package com.example.kywandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

// 1.<Start>
// onCreate -> onStart -> onResume
// 2.<Rotate>
// onPause -> onStop -> onSaveInstanceState -> onDestroy -> onCreate -> onStart -> onRestoreInstanceState -> onResume
// 3.<Background button>
// onPause -> onStop -> onSaveInstanceState
// 4.<Foreground button>
// onRestart -> onStart -> onResume
class LifeCycleActivity : AppCompatActivity() {

    val TAG = "SPELDIPN"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life_cycle)
        Log.d(TAG, "onCreate()")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("speldipn", 5025)
        Log.d(TAG, "onSaveInstanceState()")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val num = savedInstanceState.getInt("speldipn")
        Log.d(TAG, "onRestoreInstanceState() - ${num}")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy()")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart()")
    }
}