package com.example.nicolasg.funwithconstraints

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.example.nicolasg.funwithconstraints.fragments.FirstLayoutFragment

/**
 * Created by nicolas.g on 5/10/2018.
 */
class LayoutExample: AppCompatActivity() {

  private var mFragment: Fragment? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.example_layout)

    val intent: Intent = intent
    val layout = intent.getIntExtra("layout", 0)

    when(layout) {
      1 -> navigateTo(FirstLayoutFragment.newInstance(), true)
    }
  }

  fun navigateTo(fragment: Fragment, addToBackStack: Boolean) {
    val manager = supportFragmentManager

    if (!addToBackStack) {
      manager.popBackStackImmediate()
    }

    val fragmentTransaction = manager.beginTransaction()

    if (mFragment == null) {
      fragmentTransaction.add(R.id.container, fragment).commit()

    } else {

      fragmentTransaction.setCustomAnimations(
          R.anim.enter_from_right, R.anim.exit_to_left,
          R.anim.enter_from_left, R.anim.exit_to_right)
      fragmentTransaction.replace(R.id.container, fragment)
      fragmentTransaction.addToBackStack(null)
      fragmentTransaction.commit()


    }

    mFragment = fragment
  }
}