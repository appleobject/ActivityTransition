package com.appleobject.materialdesignanimation

import android.app.ActivityOptions
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Slide
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_main.*
import android.util.Pair as UtilPair

class MainActivity : AppCompatActivity() {

    lateinit var textView: TextView
    lateinit var imageView: ImageView
    lateinit var imageView2: ImageView

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById<TextView>(R.id.tv_shared_element)
        imageView = findViewById(R.id.img_view_logo)
        imageView2 = findViewById<ImageView>(R.id.shared_img)

        btn_ripple.setOnClickListener {
            val intent = Intent(this, RippleActivity::class.java)
            startActivity(intent)
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            sharedElement()
        }

        //Explode by Java - Button action
        btn_java_explode.setOnClickListener {
            val options : ActivityOptions = ActivityOptions.makeSceneTransitionAnimation(this)
            val i = Intent(this,TransitionActivity::class.java)
            i.putExtra(Constants().KEY_ANIM_TYPE,Constants.TransitionType.ExplodeJava)
            i.putExtra(Constants().KEY_TITLE, "Explode by Java")
            startActivity(i, options.toBundle())
        }

        //Explode by XML - Button action
        btn_xml_explode.setOnClickListener {
            val options : ActivityOptions = ActivityOptions.makeSceneTransitionAnimation(this)
            val i = Intent(this,TransitionActivity::class.java)
            i.putExtra(Constants().KEY_ANIM_TYPE,Constants.TransitionType.ExplodeXML)
            i.putExtra(Constants().KEY_TITLE, "Explode by XML")
            startActivity(i, options.toBundle())
        }

        //Slide by Java - Button Action
        btn_java_slide.setOnClickListener {
            val options : ActivityOptions = ActivityOptions.makeSceneTransitionAnimation(this)
            val i = Intent(this,TransitionActivity::class.java)
            i.putExtra(Constants().KEY_ANIM_TYPE,Constants.TransitionType.SlideJava)
            i.putExtra(Constants().KEY_TITLE, "Slide by Java")
            startActivity(i, options.toBundle())
        }

        //Slide by XML - Button action
        btn_xml_slide.setOnClickListener {
            val options : ActivityOptions = ActivityOptions.makeSceneTransitionAnimation(this)
            val i = Intent(this,TransitionActivity::class.java)
            i.putExtra(Constants().KEY_ANIM_TYPE,Constants.TransitionType.SlideXML)
            i.putExtra(Constants().KEY_TITLE, "Slide by XML")
            startActivity(i, options.toBundle())
        }

        //Fade by Java - Button action
        btn_java_fade.setOnClickListener {
            val options : ActivityOptions = ActivityOptions.makeSceneTransitionAnimation(this)
            val i = Intent(this,TransitionActivity::class.java)
            i.putExtra(Constants().KEY_ANIM_TYPE,Constants.TransitionType.FadeJava)
            i.putExtra(Constants().KEY_TITLE, "Fade by Java")
            startActivity(i, options.toBundle())
        }

        //Fade by XML - Button action
        btn_xml_fade.setOnClickListener {
            val options : ActivityOptions = ActivityOptions.makeSceneTransitionAnimation(this)
            val i = Intent(this,TransitionActivity::class.java)
            i.putExtra(Constants().KEY_ANIM_TYPE,Constants.TransitionType.FadeXML)
            i.putExtra(Constants().KEY_TITLE, "Fade by XML")
            startActivity(i, options.toBundle())
        }
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    private fun sharedElement() {

        shared_element.setOnClickListener {
            val options = ActivityOptions.makeSceneTransitionAnimation(
                this,
                UtilPair.create(img_view_logo, "logo_shared"),
                UtilPair.create(shared_img, "profile_pic_shared"),
                UtilPair.create(tv_shared_element, "smarthard_shared")
            )
            val intent = Intent(this, SharedElementActivity::class.java)
            startActivity(intent, options.toBundle())
        }


    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    private fun setupWindowAnimation()
    {
        val slideTransition = Slide()
        slideTransition.slideEdge = Gravity.BOTTOM
        slideTransition.duration = 1000

        window.reenterTransition = slideTransition

        // To prevent transition overlap
        window.allowReturnTransitionOverlap = false
    }

}
