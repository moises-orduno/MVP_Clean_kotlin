package com.moises.kotlin_retrofit.fragments

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import com.moises.kotlin_retrofit.adapters.MyItemRecyclerViewAdapter
import com.moises.kotlin_retrofit.R

import com.moises.kotlin_retrofit.models.Country
import com.moises.kotlin_retrofit.presenters.CountryListPresenter
import com.moises.kotlin_retrofit.presenters.CountryListPresenterImpl
import com.moises.kotlin_retrofit.view.CountryListView
import kotlinx.android.synthetic.main.fragment_item_list.*
import android.widget.AbsListView.CHOICE_MODE_SINGLE
import android.widget.ArrayAdapter
import android.content.Intent
import android.net.Uri


/**
 * A fragment representing a list of Items.
 *
 *
 * Activities containing this fragment MUST implement the [OnListFragmentInteractionListener]
 * interface.
 */
/**
 * Mandatory empty constructor for the fragment manager to instantiate the
 * fragment (e.g. upon screen orientation changes).
 */
class CountryListFragment : Fragment(), CountryListView, MyItemRecyclerViewAdapter.OnListFragmentInteractionListener {
    override fun onListFragmentInteraction(country: Country) {
        val gmmIntentUri = Uri.parse("geo:${country.latlng!!.get(0)},${country.latlng!!.get(1)}?z=5")
        val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
        mapIntent.`package` = "com.google.android.apps.maps"
        if (mapIntent.resolveActivity(context!!.getPackageManager()) != null) {
            startActivity(mapIntent)
        }    }

    override fun getEditTextCountry(): EditText {
        return mEditTextCountry
    }


    override fun setCountries(countries: List<Country>) {

        val numbers: List<Country> = countries
        mRecyclerViewCounties.layoutManager = GridLayoutManager(context, 1) as RecyclerView.LayoutManager?
        mRecyclerViewCounties!!.adapter = MyItemRecyclerViewAdapter(numbers, this)
    }

    override fun getContextFragment(): Context? {
        return context
    }

    private var mColumnCount = 1
    var mPresenter: CountryListPresenter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (arguments != null) {
            mColumnCount = arguments!!.getInt(ARG_COLUMN_COUNT)
        }

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mButtonSearch.setOnClickListener {
            mPresenter = CountryListPresenterImpl(this)
            mPresenter!!.getCountriesByName()
        }

    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_item_list, container, false)

        return view
    }


    companion object {

        private val ARG_COLUMN_COUNT = "column-count"

        fun newInstance(columnCount: Int): CountryListFragment {
            val fragment = CountryListFragment()
            val args = Bundle()
            args.putInt(ARG_COLUMN_COUNT, columnCount)
            fragment.arguments = args
            return fragment
        }
    }
}
