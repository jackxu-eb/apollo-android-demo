package com.example.apolloandroiddemo

import com.apollographql.apollo.ApolloClient
import okhttp3.OkHttpClient

object ApolloClient {
    fun getApolloClient(): ApolloClient {
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor { chain ->
            val original = chain.request()
                println("Request method: " + original.method())

            // Request customization: add request headers
            val requestBuilder = original.newBuilder()

                .header("ctoken", "")

            val request = requestBuilder.build()
            chain.proceed(request)
        }
            .build()
        return ApolloClient.builder()
            .serverUrl("")
            .okHttpClient(okHttpClient)
            .build()
    }
}