package com.quizup.kotlinbookclub.domain

import com.quizup.kotlinbookclub.Command
import com.quizup.kotlinbookclub.entities.openweathermap.ApiForecastRequest

/**
 * @author alexey@plainvanillagames.com
 *
 * 03/04/16.
 */

class ForecastRequest(val city: String): Command<ForecastList> {

    override fun execute(): ForecastList {
        val apiForecast = ApiForecastRequest(city).execute();
        return ForecastDataMapper().convertApiForecast(apiForecast)
    }

}