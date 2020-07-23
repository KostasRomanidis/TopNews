package com.kroman.topnews

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDialogFragment
import androidx.databinding.DataBindingUtil
import com.kroman.topnews.databinding.ActivityCountdownBinding

class CountDownActivity : AppCompatActivity(), SetCountDownTimeListener {

    private lateinit var progressBar: ProgressBar
    private lateinit var timeDisplay: TextView

    private lateinit var intervalCountDownTimer: IntervalCountDownTimer

    private val countDownInterval: Long = 100L
    private val secondaryProgress: Int = 100

    private lateinit var activityCountdownBinding: ActivityCountdownBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityCountdownBinding = DataBindingUtil.setContentView(this, R.layout.activity_countdown)

        activityCountdownBinding.toolbar.title = this.getString(R.string.chronometer_toolbar)
        setSupportActionBar(activityCountdownBinding.toolbar)

        progressBar = activityCountdownBinding.progressBar
        timeDisplay = activityCountdownBinding.timeDisplay

        progressBar.isIndeterminate = false
        progressBar.secondaryProgress = secondaryProgress

        intervalCountDownTimer = IntervalCountDownTimer(0, countDownInterval)
        var time = formatTime(0)

        timeDisplay.text = time

        activityCountdownBinding.setTime.setOnClickListener {
            val setCountDownTimeFragment = SetCountDownTimeFragment.newInstance()
            setCountDownTimeFragment.show(supportFragmentManager, "setTime")
        }

        activityCountdownBinding.startCountdownButton.setOnClickListener {
            intervalCountDownTimer.start()
        }

        activityCountdownBinding.pauseCountdownButton.setOnClickListener {
            intervalCountDownTimer.pause()
        }

        activityCountdownBinding.stopCountdownButton.setOnClickListener {
            intervalCountDownTimer.cancel();
        }

        activityCountdownBinding.resumeCountdownButton.setOnClickListener {
            intervalCountDownTimer.resume();
        }

        activityCountdownBinding.resetCountdownButton.setOnClickListener {
            timeDisplay.text = applicationContext.getString(R.string.time_remaining)
            progressBar.progress = 0
        }
    }


    override fun onDialogPositiveClick(
        dialogFragment: AppCompatDialogFragment,
        minutes: Int,
        seconds: Int
    ) {
        Toast.makeText(
            applicationContext, "Clicked Ok! $minutes:$seconds",
            Toast.LENGTH_SHORT
        ).show()

        val millis: Long = (minutes.toLong() * 60000) + (seconds.toLong() * 1000)
        val max: Int = (minutes * 60000) + (seconds * 1000)
        val intervalCountDownTimer: IntervalCountDownTimer =
            IntervalCountDownTimer(millis, countDownInterval)
        timeDisplay.text = formatTime(millis)
        progressBar.secondaryProgress = max
        progressBar.max = max
    }

    override fun onDialogNegativeClick(dialogFragment: AppCompatDialogFragment) {
        Toast.makeText(this, "Cancel Selected!", Toast.LENGTH_SHORT).show();
    }

    inner class IntervalCountDownTimer(millisInFuture: Long, countDownInterval: Long) :
        AltCountDownTimer(millisInFuture, countDownInterval) {

        override fun onTick(millisUntilFinished: Long) {
            val progress = millisUntilFinished as Int
            progressBar.progress = progressBar.max - progress
            timeDisplay.text = formatTime(millisUntilFinished)

        }

        override fun onFinish() {
            Toast.makeText(applicationContext, R.string.countdown_completed, Toast.LENGTH_SHORT)
                .show()
            progressBar.progress = 0
            timeDisplay.text = applicationContext.getString(R.string.time_remaining)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toobar_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_set_new_excersice -> {
                Toast.makeText(applicationContext, "Coming Soon", Toast.LENGTH_SHORT).show()
                val intent = Intent(applicationContext, SetupWorkoutActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun formatTime(millis: Long): String {
        val output: String
        var seconds: Long = millis / 1000
        var minutes: Long = seconds / 60

        seconds %= 60
        minutes %= 60

        var secondsDisplay: String = seconds.toString()
        var minutesDisplay: String = minutes.toString()

        if (seconds < 10)
            secondsDisplay = "0$seconds";
        if (minutes < 10)
            minutesDisplay = "0$minutes";
        output = "$minutesDisplay:$secondsDisplay";
        return output;
    }


}