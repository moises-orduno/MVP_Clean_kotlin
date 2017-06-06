package com.moises.kotlin_retrofit.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



/**
 * Created by mou on 03/06/17.
 */
class Country(name:String) {


    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("topLevelDomain")
    @Expose
    private var topLevelDomain: List<String>? = null
    @SerializedName("alpha2Code")
    @Expose
    private var alpha2Code: String? = null
    @SerializedName("alpha3Code")
    @Expose
    private var alpha3Code: String? = null
    @SerializedName("callingCodes")
    @Expose
    private var callingCodes: List<String>? = null
    @SerializedName("capital")
    @Expose
    var capital: String? = null
    @SerializedName("altSpellings")
    @Expose
    private var altSpellings: List<String>? = null
    @SerializedName("region")
    @Expose
    private var region: String? = null
    @SerializedName("subregion")
    @Expose
    private var subregion: String? = null
    @SerializedName("population")
    @Expose
    private var population: Int? = null
    @SerializedName("latlng")
    @Expose
    private var latlng: List<Int>? = null
    @SerializedName("demonym")
    @Expose
    private var demonym: String? = null
    @SerializedName("area")
    @Expose
    private var area: Int? = null
    @SerializedName("gini")
    @Expose
    private var gini: Double? = null
    @SerializedName("timezones")
    @Expose
    private var timezones: List<String>? = null
    @SerializedName("borders")
    @Expose
    private var borders: List<String>? = null
    @SerializedName("nativeName")
    @Expose
    private var nativeName: String? = null
    @SerializedName("numericCode")
    @Expose
    private var numericCode: String? = null
    @SerializedName("currencies")
    @Expose
    private var currencies: List<Currency>? = null
    @SerializedName("languages")
    @Expose
    private var languages: List<Language>? = null
    @SerializedName("translations")
    @Expose
    private var translations: Translations? = null
    @SerializedName("flag")
    @Expose
    private var flag: String? = null
    @SerializedName("regionalBlocs")
    @Expose
    private var regionalBlocs: List<RegionalBloc>? = null

    init {
        this.name=name
    }


}