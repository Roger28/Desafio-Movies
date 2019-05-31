package com.example.teste

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.example.teste.interfaces.Comunicator

class MainActivity : AppCompatActivity(), Comunicator {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        MainFragment.getInstance()?.let { openFragment(R.id.fragment, it) }
    }

    override fun openFragment(id: Int, fragment: Fragment) {
        val fm = supportFragmentManager
        val ft = fm.beginTransaction()
        ft.add(id, fragment)
        ft.commit()
    }

    override fun replaceFragment(id: Int, fragment: Fragment) {
        val fm = supportFragmentManager
        val ft = fm.beginTransaction()
        ft.replace(id, fragment)
        ft.addToBackStack(null)
        ft.commit()
    }
}
