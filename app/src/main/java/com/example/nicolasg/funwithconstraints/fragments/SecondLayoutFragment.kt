package com.example.nicolasg.funwithconstraints.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.nicolasg.funwithconstraints.R

/**
 * Created by nicolas.g on 5/10/2018.
 */
class SecondLayoutFragment: Fragment() {

  companion object {
    fun newInstance(): Fragment {
      return SecondLayoutFragment()
    }
  }

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
      savedInstanceState: Bundle?): View? {
    return inflater.inflate(R.layout.second_layout, container, false)
  }
}