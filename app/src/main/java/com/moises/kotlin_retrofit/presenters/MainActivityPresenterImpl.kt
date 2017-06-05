package com.moises.kotlin_retrofit.presenters

import android.content.Context
import com.moises.kotlin_retrofit.view.MainActivityView

/**
 * Created by mou on 30/05/17.
 */
class MainActivityPresenterImpl(view:MainActivityView) : BasePresenterImpl(view.getContext()),MainActivityPresenter{


    private var  mView: MainActivityView

    init{
        mView=view;
    }


    override fun setSum() {
//        mView.getTextView().setText(""+sum(1,3))
    }


    private fun sum(a: Int, b: Int) = a + b
}