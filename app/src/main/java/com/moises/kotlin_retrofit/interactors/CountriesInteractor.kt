package com.moises.kotlin_retrofit.interactors

import com.moises.kotlin_retrofit.models.Country
import rx.Subscriber

/**
 * Created by mou on 04/06/17.
 */
interface CountriesInteractor {

    fun getCountriesByName(subscriber: Subscriber<List<Country>>,name:String)

}