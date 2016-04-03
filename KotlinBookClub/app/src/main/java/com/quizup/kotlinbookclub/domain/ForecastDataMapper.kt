package com.quizup.kotlinbookclub.domain

import com.quizup.kotlinbookclub.entities.openweathermap.ForecastResult
import com.quizup.kotlinbookclub.entities.openweathermap.Forecast as ApiForecast

/**
 * @author alexey@plainvanillagames.com
 *
 * 02/04/16.
 */

class ForecastDataMapper() {

    fun convertApiForecast(forecast: ForecastResult): ForecastList {
        return ForecastList(forecast.city.name, forecast.city.country, convertApiForecastListToForecasts(forecast.list))
    }

    private fun convertApiForecastListToForecasts(list: List<ApiForecast>): List<Forecast> {
        return list.map { convertApiForecastToDomainForecast(it) }
    }

    private fun convertApiForecastToDomainForecast(apiForecast: ApiForecast): Forecast {
        return Forecast(apiForecast.dt_txt.substringBeforeLast(":"), apiForecast.weather[0].description, apiForecast.main.temp_min, apiForecast.main.temp_max)
    }
}