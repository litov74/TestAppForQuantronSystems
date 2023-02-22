package ru.litov74dev.testapplication.base

import android.app.Activity
import android.content.Context
import android.inputmethodservice.InputMethodService
import android.util.DisplayMetrics
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment

fun Activity.isTablet(): Boolean {

    val dm = DisplayMetrics()
    windowManager.defaultDisplay.getMetrics(dm)
    val x = Math.pow((dm.widthPixels / dm.xdpi).toDouble(), 2.0)
    val y = Math.pow((dm.heightPixels / dm.ydpi).toDouble(), 2.0)
    val screenInches = Math.sqrt(x + y)

    return screenInches >= 6.5

}

fun Fragment.isTablet(): Boolean {
    return activity?.isTablet() ?: false
}

fun Activity.hideKeyboard() {
    val imm = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    val view = currentFocus ?: findViewById(android.R.id.content) ?: return
    imm.hideSoftInputFromWindow(view.windowToken, 0)
}

fun Fragment.hideKeyboard() {
    activity?.hideKeyboard()
}

fun Fragment.showKeyboard(v: View) {
    val a = activity ?: return
    val keyboard = a.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    keyboard?.showSoftInput(v, 0)
}

