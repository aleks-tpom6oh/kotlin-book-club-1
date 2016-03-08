package com.quizup.kotlinbookclub

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView

/**
 * @author alexey@plainvanillagames.com
 *
 * 06/03/16.
 */

class ForecastListAdapter(val items: List<String>) : RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {

    override fun onBindViewHolder(viewHolder: ForecastListAdapter.ViewHolder, position: Int) {
        viewHolder.textView.text = items[position]
    }

    override fun getItemCount(): Int = items.count()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastListAdapter.ViewHolder? {
        return ViewHolder(TextView(parent.context))
    }

    class ViewHolder(val textView : TextView) : RecyclerView.ViewHolder(textView)
}