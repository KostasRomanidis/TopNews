package com.kroman.hiitimer;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;

import com.kroman.hiitimer.databinding.ActivitySetupWorkoutBinding;

/**
 * Created by kromanidis on 13/3/2017.
 */

public class SetupWorkoutActivity extends AppCompatActivity {
    private String workoutName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySetupWorkoutBinding activitySetupWorkoutBinding = DataBindingUtil.setContentView(this, R.layout.activity_setup_workout);
        Toolbar toolbar = activitySetupWorkoutBinding.toolbar;
        toolbar.setTitle(R.string.setup_workout_title);
        setSupportActionBar(toolbar);

        workoutName = activitySetupWorkoutBinding.setWorkoutName.getText().toString();
        activitySetupWorkoutBinding.workoutName.setText(workoutName);

    }
}
