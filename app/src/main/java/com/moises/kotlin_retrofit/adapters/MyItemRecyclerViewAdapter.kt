package com.moises.kotlin_retrofit.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.moises.kotlin_retrofit.R

import com.moises.kotlin_retrofit.fragments.CountryListFragment.OnListFragmentInteractionListener
import com.moises.kotlin_retrofit.models.Country
import kotlinx.android.synthetic.main.fragment_item.view.*

/**
 * [RecyclerView.Adapter] that can display a [Country] and makes a call to the
 * specified [OnListFragmentInteractionListener].
 * TODO: Replace the implementation with code for your data type.
 */
class MyItemRecyclerViewAdapter(private val mCountries: List<Country>, private val mListener: OnListFragmentInteractionListener?) : RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.mCountry = mCountries[position]
        holder.mView.mTextViewCountry.setText(holder.mCountry!!.name)
        holder.mView.mTextViewCapital.setText(holder.mCountry!!.capital)
        //        holder.mContentView.setText(mCountries.get(position).content);

        holder.mView.setOnClickListener {
            mListener?.onListFragmentInteraction(holder.mCountry!!)
        }
    }

    override fun getItemCount(): Int {
        return mCountries.size
    }

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {

        var mCountry: Country? = null


//        override fun toString(): String {
//            return super.toString() + " '" + mTe.text + "'"
//        }
    }
}
