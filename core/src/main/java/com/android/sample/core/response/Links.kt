package com.android.sample.core.response

import com.squareup.moshi.Json

class Links(
    @Json(name = "viaplay:sections") val sections: List<Link>
)