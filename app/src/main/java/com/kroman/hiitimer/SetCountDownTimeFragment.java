package com.kroman.hiitimer;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.NumberPicker;

import com.kroman.hiitimer.databinding.FragmentSetTimeBinding;

/**
 * Created by kromanidis on 4/3/2017.
 */

public class SetCountDownTimeFragment extends DialogFragment {
    private static final int pickerMinValue = 0;
    private static final int minutesPickerMaxValue = 99;
    private static final int secondsPickerMaxValue = 59;

    public SetCountDownTimeFragment() {
    }

    public interface SetCountDownTimeListener {
        void onDialogPositiveClick(DialogFragment dialogFragment, int minutes, int seconds);
        void onDialogNegativeClick(DialogFragment dialogFragment);
    }

    SetCountDownTimeListener mListener;

    public static SetCountDownTimeFragment newInstance() {
        SetCountDownTimeFragment fragment = new SetCountDownTimeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        FragmentSetTimeBinding fragmentSetTimeBinding = DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.fragment_set_time, null, false);
        fragmentSetTimeBinding.minutesPicker.setMinValue(pickerMinValue);
        fragmentSetTimeBinding.minutesPicker.setMaxValue(minutesPickerMaxValue);
        fragmentSetTimeBinding.secondsPicker.setMinValue(pickerMinValue);
        fragmentSetTimeBinding.secondsPicker.setMaxValue(secondsPickerMaxValue);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setView(fragmentSetTimeBinding.getRoot())
                .setTitle(R.string.dialog_title)
                .setPositiveButton(R.string.set_time, (dialog, id)  -> {
                        int minutes = fragmentSetTimeBinding.minutesPicker.getValue();
                        int seconds = fragmentSetTimeBinding.secondsPicker.getValue();
                        mListener.onDialogPositiveClick(SetCountDownTimeFragment.this, minutes, seconds);
                    }
                )
                .setNegativeButton(R.string.cancel, (dialog, id) -> {
                        SetCountDownTimeFragment.this.getDialog().cancel();
                        mListener.onDialogNegativeClick(SetCountDownTimeFragment.this);
                    }
                );
        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mListener = (SetCountDownTimeListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement SetCountDownTimeListener");
        }
    }
}
