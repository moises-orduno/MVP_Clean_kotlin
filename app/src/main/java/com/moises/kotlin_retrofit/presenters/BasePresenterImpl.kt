package com.moises.kotlin_retrofit.presenters

import android.app.ProgressDialog
import android.content.Context

/**
 * Created by mou on 31/05/17.
 */
open class BasePresenterImpl(context: Context) : BasePresenter {
    override fun showError(error: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
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