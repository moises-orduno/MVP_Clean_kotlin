package com.moises.kotlin_retrofit.presenters

import android.content.Context
import com.moises.kotlin_retrofit.interactors.CountriesInteractor
import com.moises.kotlin_retrofit.interactors.CountriesInteractorImpl
import com.moises.kotlin_retrofit.models.Country
import com.moises.kotlin_retrofit.view.CountryListView
import com.moises.kotlin_retrofit.view.MainActivityView
import rx.Subscriber

/**
 * Created by mou on 04/06/17.
 */
class CountryListPresenterImpl(view: CountryListView) : BasePresenterImpl(view.getContextFragment()), CountryListPresenter{

    private var  mView: CountryListView
    var mCountriesInteractor:CountriesInteractor


    init{
        mView=view;
        mContext=view.getContextFragment()
        mCountriesInteractor = CountriesInteractorImpl()
    }


    override fun getCountriesByName() {
        if (mView != null)
            showProgress()
        else
            return

        val query=mView.getEditTextCountry().text.toString()

        val subscriber = object : Subscriber<List<Country>>() {
            override fun onCompleted() {

            }

            override fun onError(e: Throwable) {
                showError(e.message!!)
                hideProgress()
            }

            override fun onNext(countries: List<Country>) {

                mView.setCountries(countries)
                hideProgress()

            }
        }

        mCountriesInteractor.getCountriesByName(subscriber,query)
    }
}