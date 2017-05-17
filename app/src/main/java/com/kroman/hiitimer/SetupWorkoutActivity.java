package com.kroman.hiitimer;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

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
