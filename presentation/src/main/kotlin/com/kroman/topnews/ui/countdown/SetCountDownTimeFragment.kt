package com.kroman.topnews

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatDialogFragment
import androidx.databinding.DataBindingUtil
import com.kroman.topnews.databinding.FragmentSetTimeBinding

class SetCountDownTimeFragment : AppCompatDialogFragment() {
    private val pickerMinValue: Int = 0
    private val minutesPickerMaxValue: Int = 99
    private val secondsPickerMaxValue: Int = 59

    private lateinit var mListener: SetCountDownTimeListener

    companion object {
        fun newInstance(): SetCountDownTimeFragment {
            val fragment = SetCountDownTimeFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val fragmentSetTimeBinding: FragmentSetTimeBinding = DataBindingUtil.inflate(
            LayoutInflater.from(
                context
            ), R.layout.fragment_set_time, null, false
        )
        fragmentSetTimeBinding.minutesPicker.minValue = pickerMinValue
        fragmentSetTimeBinding.minutesPicker.maxValue = minutesPickerMaxValue
        fragmentSetTimeBinding.secondsPicker.minValue = pickerMinValue
        fragmentSetTimeBinding.secondsPicker.maxValue = secondsPickerMaxValue

        val builder = AlertDialog.Builder(activity!!)
        builder
            .setView(fragmentSetTimeBinding.root)
            .setTitle(R.string.dialog_title)
            .setPositiveButton(R.string.set_time) { dialog, id ->
                val minutes: Int = fragmentSetTimeBinding.minutesPicker.value
                val seconds: Int = fragmentSetTimeBinding.secondsPicker.value
                mListener.onDialogPositiveClick(
                    dialogFragment = this,
                    minutes = minutes,
                    seconds = seconds
                )
            }
        return builder.create()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            mListener = context as SetCountDownTimeListener
        } catch (e: ClassCastException) {
            throw ClassCastException("$context must implement SetCountDownTimeListener")
        }
    }
}

interface SetCountDownTimeListener {
    fun onDialogPositiveClick(dialogFragment: AppCompatDialogFragment, minutes: Int, seconds: Int)
    fun onDialogNegativeClick(dialogFragment: AppCompatDialogFragment)
}
