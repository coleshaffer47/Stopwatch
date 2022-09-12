package com.example.stopwatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Chronometer

class MainActivity : AppCompatActivity() {

    private lateinit var startStopButton: Button
    private lateinit var resetButton: Button
    private lateinit var timer: Chronometer
    var isRunning = false

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

        startStopButton.setOnClickListener {
            if(isRunning == false) {
                startStopButton.setText("STOP")
                isRunning = true
                editTimer()
            }
            else {
                startStopButton.setText("START")
                isRunning = false
                editTimer()
            }
        }

    }

    private fun editTimer() {
        if(isRunning) {
            timer.start()
        }
        else {
            timer.stop()
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
        resetButton = findViewById(R.id.button_main_start)
        timer = findViewById(R.id.chronometer_main_stopwatch)
    }
}