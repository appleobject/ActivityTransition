package com.appleobject.materialdesignanimation

import android.animation.Animator
import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.ViewAnimationUtils
import android.view.Window
import android.view.animation.AnimationUtils
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.animation.addListener
import androidx.core.animation.doOnEnd
import kotlinx.android.synthetic.main.activity_shared_element.*

class SharedElementActivity : AppCompatActivity() {
    lateinit var click_reveal : RelativeLayout
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {

        window.requestFeature(Window.FEATURE_CONTENT_TRANSITIONS)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_element)
        click_reveal = findViewById<RelativeLayout>(R.id.click_reveal)
        initPage()
    }

    override fun onSupportNavigateUp(): Boolean {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            finishAfterTransition()
        }
        return true
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    private fun initPage()
    {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Shared Element Transition..."

        exit_button.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                finishAfterTransition()
            }
        }

        click_reveal.setOnClickListener {
            makeCircularRevealAnimation(click_reveal)
        }
    }

    @SuppressLint("SetTextI18n")
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    private fun makeCircularRevealAnimation(view : View){
        val text_desc = findViewById<TextView>(R.id.text_desc)
        val centerX = (view.left + view.right)/2
        val centerY = (view.top + view.bottom)/2

        val radius : Float = Math.max(text_desc.width , text_desc.height) * 2.0f

        if (text_desc.visibility == View.INVISIBLE)
        {
            text_desc.visibility = View.VISIBLE
            text_desc.text = "welcome to smartherd \nstay turn for more tutorial and courses".toString()
            println("CLICKING")

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                ViewAnimationUtils.createCircularReveal(
                    text_desc, centerX,centerY, 0F, radius).start()
            }
        }else{
            var reveal : Animator = ViewAnimationUtils.createCircularReveal(
                text_desc,centerX,centerY, radius,0f)
            reveal.addListener(object: Animator.AnimatorListener{
                override fun onAnimationRepeat(animation: Animator?) {

                }

                override fun onAnimationEnd(animation: Animator?) {
                    text_desc.visibility = View.INVISIBLE
                }

                override fun onAnimationCancel(animation: Animator?) {

                }

                override fun onAnimationStart(animation: Animator?) {

                }

            })
            reveal.start()


        }

    }
}