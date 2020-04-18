package com.appleobject.materialdesignanimation

import android.os.Build
import android.os.Bundle
import android.provider.SyncStateContract
import android.transition.Explode
import android.transition.Fade
import android.transition.Slide
import android.transition.TransitionInflater
import android.view.Gravity
import android.view.Window
import android.view.animation.AnticipateInterpolator
import android.view.animation.AnticipateOvershootInterpolator
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity

class TransitionActivity : AppCompatActivity() {

    lateinit var type : Constants.TransitionType
    lateinit var toolbarTitle : String
    lateinit var btn_exit : Button

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        window.requestFeature(Window.FEATURE_CONTENT_TRANSITIONS)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transition)

        initPage()
        initAnimation()
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    private fun initPage()
    {
        type = intent.getSerializableExtra(Constants().KEY_ANIM_TYPE) as Constants.TransitionType
        toolbarTitle = intent?.getStringExtra(Constants().KEY_TITLE).toString()

        btn_exit = findViewById<Button>(R.id.exit_button_trans)
        btn_exit.setOnClickListener {
            finishAfterTransition()
        }

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = toolbarTitle
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onSupportNavigateUp(): Boolean {
        finishAfterTransition()
        return true
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    private fun initAnimation()
    {
        when(type)
        {
            Constants.TransitionType.ExplodeJava ->{
                val enterTransition = Explode()
                enterTransition.duration = resources.getInteger(R.integer.anim_duration_long).toLong()
                window.enterTransition = enterTransition


            }
            Constants.TransitionType.ExplodeXML -> {
                val enterTransition = TransitionInflater.from(this).inflateTransition(R.transition.explode)
                window.enterTransition = enterTransition

            }

            Constants.TransitionType.SlideJava -> {
                val enterTransition = Slide()
                enterTransition.slideEdge = Gravity.BOTTOM
                enterTransition.interpolator = AnticipateOvershootInterpolator()
                enterTransition.duration = resources.getInteger(R.integer.anim_duration_very_long).toLong()
                window.enterTransition = enterTransition

            }

            Constants.TransitionType.SlideXML -> {
                val enterTransition = TransitionInflater.from(this).inflateTransition(R.transition.slide)
                window.enterTransition = enterTransition

            }

            Constants.TransitionType.FadeJava -> {
                val enterTransition = Fade()
                enterTransition.duration = resources.getInteger(R.integer.anim_duration_medium).toLong()
                window.enterTransition = enterTransition

            }

            Constants.TransitionType.FadeXML -> {
                val enterTransition = TransitionInflater.from(this).inflateTransition(R.transition.fade)
                window.enterTransition = enterTransition

            }
        }

    }
}