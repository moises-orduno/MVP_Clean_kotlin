package com.moises.kotlin_retrofit.api

import com.moises.kotlin_retrofit.models.Country
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import rx.Observable

/**
 * Created by mou on 04/06/17.
 */
class CountriesService {

    private val mCountriesApi: CountriesApi
    val API_URL = "https://restcountries.eu/rest/v2/"

    init {
        mCountriesApi = Retrofit.Builder()
                .baseUrl(API_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(CountriesApi::class.java!!)
    }

    companion object {
        @Volatile var mCountriesService: CountriesService? = null
        fun getInstance(): CountriesService? {
            if (mCountriesService == null) {
                synchronized(CountriesService::class.java) {
                    if (mCountriesService == null) {
                        mCountriesService = CountriesService()
                    }
                }
            }
            return mCountriesService
        }
    }


    fun getCountries(name: String): Observable<List<Country>> {
        return mCountriesApi.getByName(name)
    }

}