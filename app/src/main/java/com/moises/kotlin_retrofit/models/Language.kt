package com.moises.kotlin_retrofit.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



/**
 * Created by mou on 03/06/17.
 */
class Language {

    @SerializedName("iso639_1")
    @Expose
    private val iso6391: String? = null
    @SerializedName("iso639_2")
    @Expose
    private val iso6392: String? = null
    @SerializedName("name")
    @Expose
    private val name: String? = null
    @SerializedName("nativeName")
    @Expose
    private val nativeName: String? = null

}