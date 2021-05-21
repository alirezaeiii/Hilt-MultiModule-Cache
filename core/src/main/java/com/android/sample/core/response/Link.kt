package com.android.sample.core.response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Link(
    val id: String,
    val title: String,
    val href: String
) : Parcelable