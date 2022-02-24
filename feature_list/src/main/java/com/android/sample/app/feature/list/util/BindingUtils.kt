package com.android.sample.app.feature.list.util

import android.view.View
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.android.sample.app.feature.list.R
import com.android.sample.common.util.ViewState

@BindingAdapter("showData")
fun <T> View.showData(viewState: ViewState<T>?) {
    val labelTitle = findViewById<TextView>(R.id.label_title)
    val labelDescription = findViewById<TextView>(R.id.label_description)
    val textTitle = findViewById<TextView>(R.id.text_title)
    val textDescription = findViewById<TextView>(R.id.text_description)
    labelTitle.setVisibility(textTitle, viewState)
    labelDescription.setVisibility(textDescription, viewState)
}

private fun <T> View.setVisibility(
    textView: TextView,
    viewState: ViewState<T>?
) {
    if (viewState is ViewState.Error) {
        textView.text = null
    }
    visibility = if (textView.text.isNullOrEmpty()) View.GONE else View.VISIBLE
}