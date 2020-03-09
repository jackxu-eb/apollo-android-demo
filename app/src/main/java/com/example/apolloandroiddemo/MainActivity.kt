package com.example.apolloandroiddemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.apollographql.apollo.ApolloCall
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.exception.ApolloException


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        testBackendAPI()
    }

    private fun testBackendAPI() {
        val apolloClient = ApolloClient.getApolloClient()
        val allCompaniesQuery = AllCompaniesQuery.builder().build()
        apolloClient.query(allCompaniesQuery).enqueue(object : ApolloCall.Callback<AllCompaniesQuery.Data>() {
            override fun onFailure(e: ApolloException) {
                e.printStackTrace()
            }

            override fun onResponse(response: Response<AllCompaniesQuery.Data>) {
                println(response.data())
            }


        })
    }
}
