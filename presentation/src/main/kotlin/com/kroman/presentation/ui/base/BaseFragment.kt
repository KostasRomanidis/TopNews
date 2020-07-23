package com.kroman.presentation.ui.base

import android.view.View
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar

class BaseFragment : Fragment() {
    open fun showSnackBarMessage(view: View, message: String) {
        Snackbar.make(view, message, Snackbar.LENGTH_SHORT).show()
    }

    open fun showSnackBarMessage(@StringRes message: Int) {
        view?.let {
            (activity as BaseActivity).showSnackBarMessage(it, message)
        }
    }

    open fun showSnackBarMessage(
        @StringRes message: Int,
        @StringRes action: Int,
        unit: () -> Unit
    ) {
        view?.let {
            (activity as BaseActivity).showSnackBarMessage(it, message, action, unit)
        }
    }
}