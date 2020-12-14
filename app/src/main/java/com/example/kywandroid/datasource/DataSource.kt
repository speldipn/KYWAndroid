package com.example.kywandroid.datasource

import androidx.paging.PageKeyedDataSource
import com.example.kywandroid.model.Result
import com.example.kywandroid.network.PokeAPI
import java.io.IOException
import java.lang.Exception

class DataSource(val pokeApi: PokeAPI) : PageKeyedDataSource<String, Result>() {
    override fun loadInitial(
        params: LoadInitialParams<String>,
        callback: LoadInitialCallback<String, Result>
    ) {
        try {
            val body = pokeApi.listPokemons().execute().body()
            body?.let { body ->
                callback.onResult(body.results, body.previous, body.next)
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    override fun loadBefore(params: LoadParams<String>, callback: LoadCallback<String, Result>) {
        val queryPart = params.key.split("?")[1]
        val queries = queryPart.split("&")
        val map = mutableMapOf<String, String>()
        for (query in queries) {
            val parts = query.split("=")
            map[parts[0]] = parts[1]
        }
        try {
            val body = pokeApi.listPokemons(map["offset"]!!, map["limit"]!!).execute().body()
            body?.let {
                callback.onResult(body.results, body.previous)
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    override fun loadAfter(params: LoadParams<String>, callback: LoadCallback<String, Result>) {
        val queryPart = params.key.split("?")[1]
        val queries = queryPart.split("&")
        val map = mutableMapOf<String, String>()
        for(query in queries){
            val parts = query.split("=")
            map[parts[0]] = parts[1]
        }
        try {
            val body = pokeApi.listPokemons(map["offset"]!!, map["limit"]!!).execute().body()
            body?.let {
                callback.onResult(body.results, body.next)
            }

        } catch(e: IOException) {
            e.printStackTrace()
        }
    }

}