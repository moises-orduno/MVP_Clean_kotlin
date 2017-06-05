package com.moises.kotlin_retrofit.interactors

import com.moises.kotlin_retrofit.models.Country
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Created by mou on 04/06/17.
 */
class CountriesInteractorImpl : CountriesInteractor {

    override fun getCountriesByName(subscriber: Subscriber<List<Country>>, name: String) {
        mCountryRepository.getCountriesByName(name)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber)
    }

    private val mCountryRepository: CountriesRepository

    init{
        mCountryRepository = CountriesRepositoryImpl()
    }

}