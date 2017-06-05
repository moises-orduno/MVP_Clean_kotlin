package com.moises.kotlin_retrofit.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



/**
 * Created by mou on 03/06/17.
 */
class RegionalBloc {

    @SerializedName("acronym")
    @Expose
    private val acronym: String? = null
    @SerializedName("name")
    @Expose
    private val name: String? = null
    @SerializedName("otherAcronyms")
    @Expose
    private val otherAcronyms: List<Any>? = null
    @SerializedName("otherNames")
    @Expose
    private val otherNames: List<String>? = null

}