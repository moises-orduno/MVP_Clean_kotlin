package com.moises.kotlin_retrofit.view

import android.content.Context
import android.widget.EditText
import com.moises.kotlin_retrofit.models.Country

/**
 * Created by mou on 04/06/17.
 */
interface CountryListView {

    fun  getContextFragment(): Context

    fun setCountries(countries : List<Country> )

    fun getEditTextCountry():EditText
}