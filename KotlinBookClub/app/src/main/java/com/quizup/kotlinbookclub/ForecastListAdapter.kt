package com.quizup.kotlinbookclub

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView
import com.quizup.kotlinbookclub.domain.ForecastList

/**
 * @author alexey@plainvanillagames.com
 *
 * 06/03/16.
 */

class ForecastListAdapter(val forecast: ForecastList) : RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {

    override fun onBindViewHolder(viewHolder: ForecastListAdapter.ViewHolder, position: Int) {
        if (position == 0) {
            viewHolder.textView.text = "${forecast.city}"
        } else {
            with(forecast.dailyForecast[position - 1]) {
                viewHolder.textView.text = "$date : $description, $low to $high C"
            }
        }
    }

    override fun getItemCount(): Int = forecast.dailyForecast.count() + 1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastListAdapter.ViewHolder? {
        return ViewHolder(TextView(parent.context))
    }

    class ViewHolder(val textView : TextView) : RecyclerView.ViewHolder(textView)
}