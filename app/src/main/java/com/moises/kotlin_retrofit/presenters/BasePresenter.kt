package com.moises.kotlin_retrofit.presenters

/**
 * Created by mou on 31/05/17.
 */
interface BasePresenter {

    fun showProgress()

    fun hideProgress()

    fun showError(error :String)
}