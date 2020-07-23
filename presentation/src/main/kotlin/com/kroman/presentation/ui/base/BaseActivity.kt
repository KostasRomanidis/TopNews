package com.kroman.presentation.ui.base

import android.view.View
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

abstract class BaseActivity : AppCompatActivity() {

    fun showBackButton() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    /**
     * Show snackbar message
     */
    fun showSnackBarMessage(view: View, message: String) {
        Snackbar.make(view, message, Snackbar.LENGTH_LONG).show()
    }

    /**
     * Show snackbar message with text from string resources
     */
    fun showSnackBarMessage(view: View, @StringRes message: Int) {
        Snackbar.make(view, message, Snackbar.LENGTH_LONG).show()
    }

    /**
     * Show snackbar message with action
     */
    fun showSnackBarMessage(
        view: View,
        @StringRes message: Int,
        @StringRes action: Int,
        unit: () -> Unit
    ) {
        Snackbar.make(view, message, Snackbar.LENGTH_LONG).apply {
            setAction(action) {
                unit()
            }
        }.show()
    }
}