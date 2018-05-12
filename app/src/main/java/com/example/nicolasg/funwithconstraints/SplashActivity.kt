package com.example.nicolasg.funwithconstraints

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.view.Window
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_splash.textSplash
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper

class SplashActivity: AppCompatActivity() {

  companion object {
    private val SPLASH_TIMER: Long = 2000
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    requestWindowFeature(Window.FEATURE_NO_TITLE)
    window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        WindowManager.LayoutParams.FLAG_FULLSCREEN)
  }

  override fun onStart() {
    super.onStart()
    initViews()
    setAnimationListener()
  }

  private fun initViews() {
    setContentView(R.layout.activity_splash)
  }

  private fun setAnimationListener() {
    val logoScaleAnimation = AnimationUtils.loadAnimation(this, R.anim.scale_in)
    textSplash.startAnimation(logoScaleAnimation)

    logoScaleAnimation.setAnimationListener(object: Animation.AnimationListener {
      override fun onAnimationStart(animation: Animation) {

      }

      override fun onAnimationEnd(animation: Animation) {
        Handler().postDelayed({
          openMainActivity()
        }, SPLASH_TIMER)

        animation.cancel()
      }

      override fun onAnimationRepeat(animation: Animation) {

      }
    })
  }

  private fun openMainActivity() {
    val openSplashActivity = Intent(this@SplashActivity, MainActivity::class.java)
    openSplashActivity.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
    startActivity(openSplashActivity)
    overridePendingTransition(0, R.anim.screen_splash_fade_out)
    finish()
  }

  override fun attachBaseContext(newBase: Context) {
    super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase))
  }
}
