package com.example.svetofor

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import java.util.*

class MainActivity : Activity()
{

    var imSemafor: ImageView? = null
    var counter: Int = 0
    var timer: Timer? = null
    var is_run = false
    var imageArray: IntArray = intArrayOf(R.drawable.semafor_red, R.drawable.semafor_yellow, R.drawable.semafor_green)

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imSemafor = findViewById(R.id.imSemafor)

    }

    fun onClickStartStop(view: View)
    {
        view as ImageButton

        if (!is_run){

            StartSrop()
            view.setImageResource(R.drawable.button_stop)
            is_run = true
        }else
        {
            imSemafor?.setImageResource(R.drawable.semafor_grey)
            view.setImageResource(R.drawable.button_start)
            timer?.cancel()
            counter = 0
            is_run = false
        }


    }

    fun StartSrop()
    {
        timer = Timer()
        timer?.schedule(object :TimerTask() {
        override fun run()
        {
            runOnUiThread{                                       // тут я указал runOnUiThread для того чтобы приложение работало на любой версии андроид! ВАЖНО!!!
                imSemafor?.setImageResource(imageArray[counter])
                counter++
                if (counter == 3 )counter = 0
            }

        }
    },0,500)

    }
}