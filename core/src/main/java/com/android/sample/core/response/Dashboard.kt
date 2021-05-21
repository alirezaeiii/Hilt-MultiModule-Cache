package com.android.sample.core.response

import com.squareup.moshi.Json

class Dashboard(
    @Json(name = "_links") val links: Links
)