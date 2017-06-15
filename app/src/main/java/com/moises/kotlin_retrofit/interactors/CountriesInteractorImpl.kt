package com.moises.kotlin_retrofit.interactors

import com.moises.kotlin_retrofit.models.Country
import rx.Observable
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.functions.Func1
import rx.schedulers.Schedulers
import android.R.attr.key
import rx.internal.operators.OperatorReplay.observeOn



/**
 * Created by mou on 04/06/17.
 */
class CountriesInteractorImpl : CountriesInteractor {

    override fun getCountriesByName(subscriber: Subscriber<List<Country>>, name: String) {
        mCountryRepository.getCountriesByName(name)

//
//                .flatMap(Func1<List<Country>, Observable<Country>> { programmers -> Observable.from<Country>(programmers) }).map(Func1<Country, Country> { programmer ->
//            val newProgrammer1 = Country("name")
//            newProgrammer1
//        }).toList()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber)
    }


    private val mCountryRepository: CountriesRepository

    init{
        mCountryRepository = CountriesRepositoryImpl()
    }

}

