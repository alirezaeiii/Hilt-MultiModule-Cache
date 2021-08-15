package com.android.sample.core.network

import com.android.sample.core.response.Dashboard
import com.android.sample.core.response.Section
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiService {

    @GET("androiddash-se")
    fun getDashboard(): Observable<Dashboard>

    @GET
    fun getSection(@Url url: String): Observable<Section>
}