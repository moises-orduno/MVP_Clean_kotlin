package com.moises.kotlin_retrofit.activities

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.moises.kotlin_retrofit.R
import com.moises.kotlin_retrofit.fragments.CountryListFragment
import com.moises.kotlin_retrofit.models.Country
import com.moises.kotlin_retrofit.presenters.MainActivityPresenter
import com.moises.kotlin_retrofit.view.MainActivityView

class MainActivity : AppCompatActivity(), MainActivityView {

    override fun getContext(): Context {
        return this
    }


    private var mPresenter: MainActivityPresenter? = null
    private var mFragmentManager =supportFragmentManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)


        val itemFragment = CountryListFragment()
        mFragmentManager.beginTransaction().add(R.id.fragments_container,itemFragment, CountryListFragment.toString()).commit()

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId


        if (id == R.id.action_settings) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }
}
