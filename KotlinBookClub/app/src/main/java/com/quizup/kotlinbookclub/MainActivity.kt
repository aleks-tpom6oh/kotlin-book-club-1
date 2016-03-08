package com.quizup.kotlinbookclub

import android.app.Activity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val items = listOf("Today - Sunny", "Tomorrow - Foggy", "Later - Sunny")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var textView = findViewById(R.id.text_view) as TextView
        textView.text = "Hey-ho"

        message.text = "Lets go!"

        toast("Long toast")
        toast("Long toast", "Tagged")
        toast("Short toast", "Tagged", Toast.LENGTH_SHORT)
        toast("Short toast", length = Toast.LENGTH_LONG)

        forecast_list.layoutManager = LinearLayoutManager(this)
        forecast_list.adapter = ForecastListAdapter(items)

        savedInstanceState?.getShortArray("")
    }
}

fun Activity.toast(message: String, tag: String = this.javaClass.simpleName, length: Int = Toast.LENGTH_LONG) {
    android.widget.Toast.makeText(this, " [$tag] $message", length).show()
}