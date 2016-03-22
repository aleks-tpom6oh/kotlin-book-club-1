package com.quizup.kotlinbookclub

import android.app.Activity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import com.google.gson.Gson
import com.quizup.kotlinbookclub.entities.WeatherResult
import kotlinx.android.synthetic.main.activity_main.*
import java.net.URL
import org.jetbrains.anko.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        var textView = findViewById(R.id.text_view) as TextView
//        textView.text = "Hey-ho"
//
//        message.text = "Lets go!"
//
//        toast("Long toast")
//        toast("Long toast", "Tagged")
//        toast("Short toast", "Tagged", Toast.LENGTH_SHORT)
//        toast("Short toast", length = Toast.LENGTH_LONG)


        val act = this


        async() {
            val forecastJsonStr = URL("http://apis.is/weather/observations/is?stations=1").readText()
            uiThread {
                val weatherResult = Gson().fromJson(forecastJsonStr, WeatherResult::class.java)
                val information = listOf(weatherResult.results[0].name,
                        weatherResult.results.get(0).time,
                        weatherResult.results.get(0).W)
                forecast_list.layoutManager = LinearLayoutManager(act)
                forecast_list.adapter = ForecastListAdapter(information)
            }
        }

        savedInstanceState?.getShortArray("")
    }

}

fun Activity.toast(message: String, tag: String = this.javaClass.simpleName, length: Int = Toast.LENGTH_LONG) {
    android.widget.Toast.makeText(this, " [$tag] $message", length).show()
}