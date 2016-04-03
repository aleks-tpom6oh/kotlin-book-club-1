package com.quizup.kotlinbookclub

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.google.gson.Gson
import com.quizup.kotlinbookclub.domain.ForecastRequest
import com.quizup.kotlinbookclub.entities.apisis.WeatherResult
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.async
import org.jetbrains.anko.uiThread
import java.net.URL

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        async() {
            val forecastJsonStr = URL("http://apis.is/weather/observations/is?stations=1").readText()
            val weatherResult = Gson().fromJson(forecastJsonStr, WeatherResult::class.java)

            val forecast = ForecastRequest("Reykjavik").execute()

            val information = listOf(weatherResult.results[0].name,
                    weatherResult.results[0].time,
                    weatherResult.results[0].T + "C",
                    forecast.dailyForecast[0].description + " tomorrow")

            uiThread {
                forecast_list.layoutManager = LinearLayoutManager(this@MainActivity)
                forecast_list.adapter = ForecastListAdapter(information)
            }
        }

        savedInstanceState?.getShortArray("")
    }
}