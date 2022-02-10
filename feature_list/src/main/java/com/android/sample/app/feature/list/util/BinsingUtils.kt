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
    setVisibility(textTitle, labelTitle, viewState)
    setVisibility(textDescription, labelDescription, viewState)
}

private fun <T> setVisibility(
    textView: TextView,
    labelText: TextView,
    viewState: ViewState<T>?
) {
    val visibility = if (viewState is ViewState.Error ||
        textView.text.isEmpty()
    ) View.GONE else View.VISIBLE
    labelText.visibility = visibility
}