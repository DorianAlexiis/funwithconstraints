package com.example.nicolasg.funwithconstraints

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_main.firstLayoutButton

class MainActivity: AppCompatActivity(), View.OnClickListener {

  var layoutResId: Int = 0

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    firstLayoutButton.setOnClickListener(this)
  }

  override fun onClick(view: View?) {

    when(view?.id) {
      R.id.firstLayoutButton -> {
        layoutResId = R.layout.first_layout
        openActivity(this, LayoutExample::class.java, 1)
      }

    }
  }

  private fun openActivity(activity: Activity, nextActivity: Class<*>,
      layout: Int) {
    val intent = Intent(activity, nextActivity)
    intent.putExtra("layout", layout)
    startActivity(intent)
    overridePendingTransition(0, R.anim.screen_splash_fade_out)
  }
}
