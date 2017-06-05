package com.moises.kotlin_retrofit.api


import com.moises.kotlin_retrofit.models.Country

import retrofit2.http.GET
import retrofit2.http.Path
import rx.Observable

interface CountriesApi {

    @GET("name/{name}")
    fun getByName(@Path("name") name:String): Observable<List<Country>>
}
