package com.example.kywandroid

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color.red
import android.graphics.Paint
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kywandroid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        Log.d(TAG, ">>>>>> start")
        runExample()
        Log.d(TAG, ">>>>>> end")
    }

    private fun runExample() {
        val adapter = MainRecyclerViewAdapter()
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.recyclerView.addItemDecoration(DivideDecoration(this))
        adapter.setDataAndRefresh(listOf("aa", "bb", "cc", "dd", "ee", "ff", "gg"))
    }

    inner class DivideDecoration(context: Context) : RecyclerView.ItemDecoration() {
        private val paint: Paint = Paint()
        val strokeWidth = 2

        init {
            paint.strokeWidth = context.resources.displayMetrics.density * strokeWidth
            paint.color = ContextCompat.getColor(context, R.color.red)
        }

        override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
            for (i in 0 until parent.childCount) {
                val view = parent.getChildAt(i)
                c.drawLine(
                    view.left.toFloat(),
                    view.bottom.toFloat(),
                    view.right.toFloat(),
                    view.bottom.toFloat(),
                    paint
                )

            }
        }
    }

    companion object {
        val TAG = "speldipn"
    }

}
