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
class CountryListFragment : Fragment(), CountryListView {

    override fun getEditTextCountry(): EditText {
        return mEditTextCountry
    }


    override fun setCountries(countries: List<Country>) {

        val numbers: List<Country> = countries
        mRecyclerViewCounties.layoutManager = GridLayoutManager(context, 1) as RecyclerView.LayoutManager?
        mRecyclerViewCounties!!.adapter = MyItemRecyclerViewAdapter(numbers, mListener)
    }

    override fun getContextFragment(): Context {
        return context
    }

    private var mColumnCount = 1
    private var mListener: OnListFragmentInteractionListener? = null
    var mPresenter: CountryListPresenter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (arguments != null) {
            mColumnCount = arguments.getInt(ARG_COLUMN_COUNT)
        }

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mButtonSearch.setOnClickListener {
            mPresenter = CountryListPresenterImpl(this)
            mPresenter!!.getCountriesByName()
        }

    }


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater!!.inflate(R.layout.fragment_item_list, container, false)

        return view
    }


    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is OnListFragmentInteractionListener) {
            mListener = context as OnListFragmentInteractionListener?
        } else {
            throw RuntimeException(context!!.toString() + " must implement OnListFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        mListener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments](http://developer.android.com/training/basics/fragments/communicating.html) for more information.
     */
    interface OnListFragmentInteractionListener {
        fun onListFragmentInteraction(country: Country)
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
