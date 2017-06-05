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
import com.moises.kotlin_retrofit.adapters.MyItemRecyclerViewAdapter
import com.moises.kotlin_retrofit.R

import com.moises.kotlin_retrofit.models.Country
import com.moises.kotlin_retrofit.presenters.CountryListPresenter
import com.moises.kotlin_retrofit.presenters.CountryListPresenterImpl
import com.moises.kotlin_retrofit.view.CountryListView


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
class CountryListFragment : Fragment(),CountryListView {
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

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_item_list, container, false)

        mPresenter=CountryListPresenterImpl(this)
        mPresenter!!.getCountriesByName()
        // Set the adapter
        if (view is RecyclerView) {
            val context = view.getContext()
            val recyclerView = view
            if (mColumnCount <= 1) {
                recyclerView.layoutManager = LinearLayoutManager(context)
            } else {
                recyclerView.layoutManager = GridLayoutManager(context, mColumnCount)
            }

            val country= Country("mexico")
            val numbers: MutableList<Country> = mutableListOf(country,country)

            numbers.add(Country("united"))
            recyclerView.adapter = MyItemRecyclerViewAdapter(numbers!!, mListener)
        }
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
