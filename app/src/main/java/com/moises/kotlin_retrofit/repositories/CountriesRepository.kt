package com.moises.kotlin_retrofit.interactors

import com.moises.kotlin_retrofit.models.Country
import rx.Observable

/**
 * Created by mou on 04/06/17.
 */
interface CountriesRepository {

    fun getCountriesByName(name: String): Observable<List<Country>>

}