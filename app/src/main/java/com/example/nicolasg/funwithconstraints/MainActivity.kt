package com.example.nicolasg.funwithconstraints

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_main.eightLayoutButton
import kotlinx.android.synthetic.main.activity_main.firstLayoutButton
import kotlinx.android.synthetic.main.activity_main.fiveLayoutButton
import kotlinx.android.synthetic.main.activity_main.fourLayoutButton
import kotlinx.android.synthetic.main.activity_main.secondLayoutButton
import kotlinx.android.synthetic.main.activity_main.sevenLayoutButton
import kotlinx.android.synthetic.main.activity_main.sixLayoutButton
import kotlinx.android.synthetic.main.activity_main.thirdLayoutButton

class MainActivity: AppCompatActivity(), View.OnClickListener {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    firstLayoutButton.setOnClickListener(this)
    secondLayoutButton.setOnClickListener(this)
    thirdLayoutButton.setOnClickListener(this)
    fourLayoutButton.setOnClickListener(this)
    fiveLayoutButton.setOnClickListener(this)
    sixLayoutButton.setOnClickListener(this)
    sevenLayoutButton.setOnClickListener(this)
    eightLayoutButton.setOnClickListener(this)
  }

  override fun onClick(view: View?) {

    when(view?.id) {
      R.id.firstLayoutButton -> openActivity(this, LayoutExample::class.java, 1)
      R.id.secondLayoutButton -> openActivity(this, LayoutExample::class.java, 2)
      R.id.thirdLayoutButton -> openActivity(this, LayoutExample::class.java, 3)
      R.id.fourLayoutButton -> openActivity(this, LayoutExample::class.java, 4)
      R.id.fiveLayoutButton -> openActivity(this, LayoutExample::class.java, 5)
      R.id.sixLayoutButton -> openActivity(this, LayoutExample::class.java, 6)
      R.id.sevenLayoutButton -> openActivity(this, LayoutExample::class.java, 7)
      R.id.eightLayoutButton -> openActivity(this, LayoutExample::class.java, 8)
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
