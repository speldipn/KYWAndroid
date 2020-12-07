package com.example.kywandroid

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableField
import androidx.recyclerview.widget.RecyclerView
import com.example.kywandroid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val viewModel by lazy { ViewModel() }
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewModel = viewModel
        Log.d(TAG, ">>>>>> start")
        runExample()
        Log.d(TAG, ">>>>>> end")
    }

    private fun runExample() {
    }

    inner class ViewModel {
        var recyclerView = ObservableField<RecyclerView>()
    }

    companion object {
        val TAG = "speldipn"
    }

}
