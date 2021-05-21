package com.android.sample.common.extension

fun String.cleanHref() = this.replace("{?dtg}", "")