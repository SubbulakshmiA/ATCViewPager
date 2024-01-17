package com.example.atc

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.RatingBar
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomappbar.BottomAppBar
import java.util.Calendar


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var seek : SeekBar  = findViewById(R.id.seekbar)
        var ratingBar:RatingBar = findViewById(R.id.ratingbar)
        val bottomAppBar = findViewById<BottomAppBar>(R.id.bottom_bar)
        setSupportActionBar(bottomAppBar)
        var dateBtn : Button = findViewById(R.id.date_btn)
        val timeBtn:Button = findViewById(R.id.time_btn)
        var dateTv:TextView = findViewById(R.id.date_tv)
        val timeTv:TextView = findViewById(R.id.time_tv)

        ratingBar.numStars = 4
        seek.max = 100
        val c = Calendar.getInstance()

        dateBtn.setOnClickListener {
            val day = c.get(Calendar.DAY_OF_MONTH)
            val month = c.get(Calendar.MONTH)
            val year = c.get(Calendar.YEAR)

        val myDatePicker = DatePickerDialog(this,
            DatePickerDialog.OnDateSetListener {DatePicker,year,month,day ->
            dateTv.text = "$day/ ${month+1}/$year"},year,month,day )
            myDatePicker.show()
         }

        timeBtn.setOnClickListener {
            val hour = c.get(Calendar.HOUR)
            val min = c.get(Calendar.MINUTE)
            var hourOfDay1 = 0
            val myTimePicker = TimePickerDialog(this,
                TimePickerDialog.OnTimeSetListener { TimePicker, hourOfDay, minute ->
                    var am_pm = ""
                    if (hourOfDay == 0) {
                        hourOfDay1 = hourOfDay + 12
                        am_pm = "am"
                    } else if (hourOfDay > 12 ) {
                        hourOfDay1 = hourOfDay-12;
                        am_pm = "pm"
                    } else if ( hourOfDay == 12) {
                        hourOfDay1 = hourOfDay;
                        am_pm = "pm"
                    }else{
                        hourOfDay1 = hourOfDay
                        am_pm = "am"
                    }
            timeTv.text = "$hourOfDay1 : $minute ${am_pm}"},hour,min,false)
            myTimePicker.show()
        }

        ratingBar.onRatingBarChangeListener =
            RatingBar.OnRatingBarChangeListener { ratingBar, rating, fromUser ->
                Toast.makeText(this@MainActivity,"ratingBar ${rating.toString()}",Toast.LENGTH_LONG).show()
            }


        seek.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                Toast.makeText(this@MainActivity,"changed ${p1.toString()}",Toast.LENGTH_LONG).show()
            }
            override fun onStartTrackingTouch(p0: SeekBar?) {}
            override fun onStopTrackingTouch(p0: SeekBar?) {}

        })
    }
}