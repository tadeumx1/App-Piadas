package com.example.appiadas

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var tvJoker : TextView
    lateinit var tvJokerResult : TextView
    lateinit var btTellJoker: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvJoker = findViewById(R.id.tvJoker)
        tvJokerResult = findViewById(R.id.tvJokerResult)
        btTellJoker = findViewById(R.id.btTellJoker)

        showJoker()

        btTellJoker.setOnClickListener {
            showJoker()
        }
    }

    private fun showJoker() {
        val jokers = resources.getStringArray(R.array.jokers)
        val jokersResult = resources.getStringArray(R.array.jokers_answers)
        val numberJoker = Random().nextInt(jokers.size)
        val joker = jokers[numberJoker]
        val jokerResult = jokersResult[numberJoker]

        tvJokerResult.visibility = View.GONE

        tvJoker.text = joker

        val timeDelay = 3000

        Handler(Looper.getMainLooper()).postDelayed ({
            tvJokerResult.visibility = View.VISIBLE
            tvJokerResult.text = jokerResult

            playSong()
        }, timeDelay.toLong())
    }

    private fun playSong() {
        val mediaPlayer = MediaPlayer.create(this, R.raw.badumtss)
        mediaPlayer.start()
    }

}