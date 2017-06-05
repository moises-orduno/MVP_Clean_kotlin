package com.moises.kotlin_retrofit.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by mou on 03/06/17.
 */

class Currency {

    @SerializedName("code")
    @Expose
    var code: String? = null
    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("symbol")
    @Expose
    var symbol: String? = null

}
