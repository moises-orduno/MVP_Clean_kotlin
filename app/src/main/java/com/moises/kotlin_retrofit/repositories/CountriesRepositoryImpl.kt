package com.moises.kotlin_retrofit.interactors

import com.moises.kotlin_retrofit.api.CountriesService
import com.moises.kotlin_retrofit.models.Country
import rx.Observable

/**
 * Created by mou on 04/06/17.
 */
class CountriesRepositoryImpl : CountriesRepository {

    override fun getCountriesByName(name: String): Observable<List<Country>> {
        return mCountriesService.getCountries(name)
    }

    private val mCountriesService: CountriesService

    init{
        mCountriesService = CountriesService.getInstance() as CountriesService

    }

}