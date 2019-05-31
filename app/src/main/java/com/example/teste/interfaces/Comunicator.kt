package com.example.teste.interfaces

import android.support.v4.app.Fragment

interface Comunicator {
    fun openFragment(id: Int, fragment: Fragment)

    fun replaceFragment(id: Int, fragment: Fragment)
}
