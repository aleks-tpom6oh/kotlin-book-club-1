package com.quizup.kotlinbookclub

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.quizup.kotlinbookclub.domain.ForecastRequest
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.async
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        async() {
            val forecast = ForecastRequest("Reykjavik").execute()

            uiThread {
                forecast_list.layoutManager = LinearLayoutManager(this@MainActivity)
                forecast_list.adapter = ForecastListAdapter(forecast)
            }
        }

        savedInstanceState?.getShortArray("")
    }
}