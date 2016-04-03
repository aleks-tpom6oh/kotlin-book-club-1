package com.quizup.kotlinbookclub.entities.openweathermap

import com.google.gson.Gson
import com.quizup.kotlinbookclub.Command
import java.net.URL

/**
 * @author alexey@plainvanillagames.com
 *
 * 02/04/16.
 */

class ApiForecastRequest(val cityName: String): Command<ForecastResult> {

    companion object {
        val appId = "d1023d268e9e55dd15d7ec661387c8f8"
        val url = "http://api.openweathermap.org/data/2.5/forecast?mode=json&appid=${appId}&q=";
    }

    override fun execute(): ForecastResult {
        val forecastJsonString = URL(url + cityName).readText()
        return Gson().fromJson(forecastJsonString, ForecastResult::class.java)
    }
}