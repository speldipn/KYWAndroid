package com.example.kywandroid

import android.widget.TextView
import androidx.databinding.BindingAdapter

class bindingadapter {
    object TextViewBindingAdapter {
        @BindingAdapter("reverseText")
        @JvmStatic
        fun setReverseText(view: TextView, string: String) {
            view.text = StringBuilder(string).reverse().toString()
        }
    }
}