package com.quizup.kotlinbookclub.domain

/**
 * @author alexey@plainvanillagames.com
 *
 * 02/04/16.
 */

data class ForecastList(val city: String, val country: String, val dailyForecast: List<Forecast>)

data class Forecast(val date: String, val description: String, val low: Double, val high: Double)