package com.quizup.kotlinbookclub.domain

/**
 * @author alexey@plainvanillagames.com
 *
 * 02/04/16.
 */

data class ForecastList(val city: String, val country: String, val dailyForecast: List<Forecast>) {
    operator fun get(position: Int) : Forecast = dailyForecast[position]

    fun size(): Int = dailyForecast.size
}

data class Forecast(val date: String, val description: String, val low: Double, val high: Double)