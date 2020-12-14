package com.example.kywandroid.model

data class Response(
    var count: Int,
    var previous: String,
    var next: String,
    var results: List<Result>
)