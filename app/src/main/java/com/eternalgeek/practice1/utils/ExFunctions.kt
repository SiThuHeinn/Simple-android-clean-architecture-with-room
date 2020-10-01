package com.eternalgeek.practice1.utils

import android.app.Dialog
import android.content.Context
import android.view.Window


fun Context.getPlainDialog(layout : Int, cancelable : Boolean): Dialog {
    val dialog = Dialog(this)
    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
    dialog.setContentView(layout)
    dialog.setCancelable(cancelable)

    return dialog
}