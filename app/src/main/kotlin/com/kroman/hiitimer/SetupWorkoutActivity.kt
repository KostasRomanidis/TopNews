package com.kroman.hiitimer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.kroman.hiitimer.databinding.ActivitySetupWorkoutBinding

class SetupWorkoutActivity : AppCompatActivity() {
    var workoutName: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activitySetupWorkoutBinding: ActivitySetupWorkoutBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_setup_workout)
        val toolbar = activitySetupWorkoutBinding.toolbar
        toolbar.setTitle(R.string.setup_workout_title)
        setSupportActionBar(toolbar)

        workoutName = activitySetupWorkoutBinding.setWorkoutName.text.toString()
        activitySetupWorkoutBinding.workoutName.text = workoutName
    }
}