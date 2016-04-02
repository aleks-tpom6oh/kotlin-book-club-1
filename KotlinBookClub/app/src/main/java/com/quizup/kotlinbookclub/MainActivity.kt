package com.quizup.kotlinbookclub

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.google.gson.Gson
import com.quizup.kotlinbookclub.entities.apisis.WeatherResult
import com.quizup.kotlinbookclub.entities.openweathermap.ForecastRequest
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.async
import org.jetbrains.anko.uiThread
import java.net.URL

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        forecast_list.layoutManager = LinearLayoutManager(this)

        async() {
            val forecastJsonStr = URL("http://apis.is/weather/observations/is?stations=1").readText()
            val weatherResult = Gson().fromJson(forecastJsonStr, WeatherResult::class.java)

            val forecastResult = ForecastRequest("Reykjavik").execute()

            uiThread {
                val information = listOf(weatherResult.results[0].name,
                        weatherResult.results[0].time,
                        weatherResult.results[0].T + "C",
                        forecastResult.list[0].weather[0].description + " tomorrow")
                forecast_list.adapter = ForecastListAdapter(information)
            }
        }

        savedInstanceState?.getShortArray("")
    }
}