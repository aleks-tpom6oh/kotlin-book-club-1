package com.quizup.kotlinbookclub.entities.openweathermap

/**
 * @author alexey@plainvanillagames.com
 *
 * 02/04/16.
 */

data class ForecastResult(val city: City, val list: List<Forecast>)
data class City(val id: Long, val name: String, val coord: Coordinates, val country: String, val population: Int)
data class Coordinates(val lon: Float, val lat: Float)
data class Forecast(val dt: Long, val main: MainForecast,
                    val weather: List<Weather>, val clouds: Clouds, val wind: Wind, val rain: Map<String, Double>)
data class Weather(val id: Long, val main: String, val description: String, val icon: String)
data class MainForecast(val temp: Double, val pressure: Double, val humidity: Int)
data class Wind(val speed: Double, val deg: Double)
data class Clouds(val all: Int)