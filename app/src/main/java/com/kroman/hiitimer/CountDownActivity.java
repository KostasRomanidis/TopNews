package com.kroman.hiitimer;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.kroman.hiitimer.databinding.ActivityCountdownBinding;


/**
 * Created by kromanidis on 25/2/2017.
 */

public class CountDownActivity extends AppCompatActivity implements SetCountDownTimeFragment.SetCountDownTimeListener {
    private ProgressBar progressBar;
    private TextView timeDisplay;

    private IntervalCountDownTimer intervalCountDownTimer;

    private static final long countDownInterval = 100;
    private static final int secondaryProgress = 100;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCountdownBinding countdownActivityBinding = DataBindingUtil.setContentView(this, R.layout.activity_countdown);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.chronometer_toolbar);
        setSupportActionBar(toolbar);

        progressBar = countdownActivityBinding.progressBar;
        timeDisplay = countdownActivityBinding.timeDisplay;
        progressBar.setIndeterminate(false);
        progressBar.setSecondaryProgress(secondaryProgress);

        intervalCountDownTimer = new IntervalCountDownTimer(0, countDownInterval);
        String time = formatTime(0);
        timeDisplay.setText(time);

        countdownActivityBinding.setTime.setOnClickListener(v -> {
            SetCountDownTimeFragment setCountDownTimeFragment = SetCountDownTimeFragment.newInstance();
            setCountDownTimeFragment.show(getSupportFragmentManager(), "setTime");
        });

        countdownActivityBinding.startCountdownButton.setOnClickListener(v -> {
            intervalCountDownTimer.start();
         });

        countdownActivityBinding.pauseCountdownButton.setOnClickListener(v -> {
            intervalCountDownTimer.pause();
        });

        countdownActivityBinding.stopCountdownButton.setOnClickListener(v -> {
            intervalCountDownTimer.cancel();
        });

        countdownActivityBinding.resumeCountdownButton.setOnClickListener(v -> {
            intervalCountDownTimer.resume();
        });

        countdownActivityBinding.resetCountdownButton.setOnClickListener(v -> {
            timeDisplay.setText(R.string.time_remaining);
            progressBar.setProgress(0);
        });
    }

    @Override
    public void onDialogPositiveClick(DialogFragment dialogFragment, int minutes, int seconds) {
        Toast.makeText(CountDownActivity.this, "Clicked Ok! " + String.valueOf(minutes) + ":" + String.valueOf(seconds), Toast.LENGTH_SHORT).show();
        long millis = ((long) minutes * 60000) + ((long) seconds * 1000);
        int max = (minutes * 60000) + (seconds * 1000);
        intervalCountDownTimer = new IntervalCountDownTimer(millis, countDownInterval);
        timeDisplay.setText(formatTime(millis));
        progressBar.setSecondaryProgress(max);
        progressBar.setMax(max);
    }

    @Override
    public void onDialogNegativeClick(DialogFragment dialogFragment) {
        Toast.makeText(CountDownActivity.this, "Cancel Selected!", Toast.LENGTH_SHORT).show();
    }

    public class IntervalCountDownTimer extends AltCountDownTimer {

        public IntervalCountDownTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            int progress = (int) (millisUntilFinished);
            progressBar.setProgress(progressBar.getMax() - progress);
            String timeRemaining = formatTime(millisUntilFinished);
            timeDisplay.setText(timeRemaining);
        }

        @Override
        public void onFinish() {
            Toast.makeText(CountDownActivity.this, R.string.countdown_completed, Toast.LENGTH_SHORT).show();
            progressBar.setProgress(0);
            timeDisplay.setText(R.string.time_remaining);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toobar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_set_new_excersice:
                Toast.makeText(this, "Coming Soon", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, SetupWorkoutActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private String formatTime(long millis) {
        String output;
        long seconds = millis / 1000;
        long minutes = seconds / 60;

        seconds = seconds % 60;
        minutes = minutes % 60;

        String secondsDisplay = String.valueOf(seconds);
        String minutesDisplay = String.valueOf(minutes);

        if (seconds < 10 )
            secondsDisplay = "0" + seconds;
        if (minutes < 10)
            minutesDisplay = "0" + minutes;

        output = minutesDisplay + ":" + secondsDisplay;

        return output;
    }
}
