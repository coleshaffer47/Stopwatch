package com.example.stopwatch

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import android.widget.Button
import android.widget.Chronometer

class MainActivity : AppCompatActivity() {

    private lateinit var startStopButton: Button
    private lateinit var resetButton: Button
    private lateinit var timer: Chronometer
    var isRunning = false
    var timerBase = SystemClock.elapsedRealtime()
    var timerStopped = SystemClock.elapsedRealtime()
    var timerResumed = SystemClock.elapsedRealtime()

    //make a classwide static constant in Kotlin
    companion object {
        //all your static constants go here
        val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate:")
        wireWidgets()
        startStopButton.setBackgroundColor(Color.rgb(63, 176, 73))
        resetButton.setBackgroundColor(Color.rgb(196, 97, 242))

        resetButton.setOnClickListener {
            //RESET TIMER, RESET OTHER BUTTON
            timerBase = 0
            timerStopped = 0
            timerResumed = 0
            timer.base = SystemClock.elapsedRealtime()
            timer.stop()
            startStopButton.setBackgroundColor(Color.rgb(63, 176, 73))
            startStopButton.setText("START")
            isRunning = false
        }

        startStopButton.setOnClickListener {
            if(isRunning == false) {
                //STARTING TIMER
                timerResumed = SystemClock.elapsedRealtime()
                timerBase = timerResumed - (timerStopped - timerBase)
                timer.base = timerBase
                startStopButton.setText("STOP")
                isRunning = true
                editTimer()
            }
            else {
                //STOPPING TIMER
                timerStopped = SystemClock.elapsedRealtime()
                startStopButton.setText("RESUME")
                isRunning = false
                editTimer()
            }
        }

    }

    private fun editTimer() {
        if(isRunning) {
            timer.start()
            startStopButton.setBackgroundColor(Color.rgb(252, 70, 45))
        }
        else {
            timer.stop()
            startStopButton.setBackgroundColor(Color.rgb(63, 176, 73))
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: ")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart:")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume:")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause:")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop:")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy:")
    }

    private fun wireWidgets() {
        startStopButton = findViewById(R.id.button_main_start)
        resetButton = findViewById(R.id.button_main_reset)
        timer = findViewById(R.id.chronometer_main_stopwatch)
    }
}