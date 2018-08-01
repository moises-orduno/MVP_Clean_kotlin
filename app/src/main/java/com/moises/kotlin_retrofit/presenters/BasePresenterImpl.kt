package com.moises.kotlin_retrofit.presenters

import android.app.ProgressDialog
import android.content.Context
import android.widget.Toast

/**
 * Created by mou on 31/05/17.
 */
open class BasePresenterImpl(context: Context) : BasePresenter {
    override fun showError(error: String) {
       Toast.makeText(mContext,error,Toast.LENGTH_LONG).show()
    }

    private var dialog: ProgressDialog

    override fun hideProgress() {
        dialog.dismiss()
    }

    var mContext: Context

    init {
        mContext = context
        dialog = ProgressDialog(mContext)
    }

    override fun showProgress() {
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER)
        dialog.setMessage("Loading. Please wait...")
        dialog.setIndeterminate(true)
        dialog.setCanceledOnTouchOutside(false)
        dialog.show()
    }
}