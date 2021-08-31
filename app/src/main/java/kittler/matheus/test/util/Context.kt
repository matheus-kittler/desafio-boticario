package kittler.matheus.test.util

import android.app.AlertDialog
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.google.android.material.textfield.TextInputLayout
import kittler.matheus.test.R

fun Context.showAlert (title: String, message: String, setup: (AlertDialog.Builder.() -> Unit)? = null) {
    val alert = AlertDialog.Builder(this)
    alert.setTitle(title)
    alert.setMessage(message)
    setup?.invoke(alert)
    alert.show()
}

fun Context.showFieldError(view: TextInputLayout, errorMessage: String) {
    view.isErrorEnabled = true
    view.error = errorMessage
}

fun Context.clearField(view: TextInputLayout) {
    view.isErrorEnabled = false
    view.error = null
}

fun View.hideKeyboard() {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(windowToken, 0)
}