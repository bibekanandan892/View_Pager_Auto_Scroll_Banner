package com.isu.viewpaget

import android.annotation.SuppressLint
import com.isu.viewpaget.R
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import java.util.*

var currentPage = 0
var timer: Timer? = null
const val DELAY_MS: Long = 500 //delay in milliseconds before task is to be executed

const val PERIOD_MS: Long = 3000 // time in milliseconds between successive task executions.


class MainActivity : AppCompatActivity() {
    var viewPager: ViewPager? = null


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageId =
            arrayOf<Int>(R.drawable.test1, R.drawable.test3, R.drawable.testw)
        val imagesName = arrayOf("image1", "image2", "image3")


        viewPager = findViewById<View>(R.id.viewPager) as ViewPager
        val adapter: PagerAdapter = CustomAdapter(this@MainActivity, imageId, imagesName)
        viewPager!!.adapter = adapter

        /*After setting the adapter use the timer */

        /*After setting the adapter use the timer */
        val handler = Handler()
        val Update = Runnable {
            if (currentPage === 4 - 1) {
                currentPage = 0
            }
            viewPager!!.setCurrentItem(currentPage++, true)
        }

        timer = Timer()

        timer!!.schedule(object : TimerTask() {
            override fun run() {
                handler.post(Update)
            }
        }, DELAY_MS, PERIOD_MS)
    }
}