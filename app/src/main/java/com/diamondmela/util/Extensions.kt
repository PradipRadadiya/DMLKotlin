package com.diamondmela.util

import android.app.Activity
import android.widget.Toast
import androidx.core.text.htmlEncode
import com.diamondmela.R
import es.dmoral.toasty.Toasty

fun Activity.showToast(message: String) {
    val toast = Toast.makeText(this, message, Toast.LENGTH_LONG)
    val view1 = toast.view
    toast.view.setPadding(20, 20, 20, 20)
    view1.setBackgroundResource(R.color.green)
    //        view1.setTextColor(Color.WHITE);
    toast.show()

}

fun Activity.showSuccessToast(message: String) {
    Toasty.success(this, message, Toast.LENGTH_LONG, true).show()

}

fun Activity.showErrorToast(message: String) {
    Toasty.error(this, message, Toast.LENGTH_LONG, true).show()

}

fun Activity.showInfoToast(message: String) {
    Toasty.info(this, message, Toast.LENGTH_LONG, true).show()

}

fun Activity.showWarningToast(message: String) {
    Toasty.warning(this, message, Toast.LENGTH_LONG, true).show()

}
