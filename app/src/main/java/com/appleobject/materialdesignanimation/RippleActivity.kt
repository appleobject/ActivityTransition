package com.appleobject.materialdesignanimation

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.ripple_activity.*


class RippleActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ripple_activity)

        supportActionBar?.title = "Ripple Animations"

        dummy_click3.setOnClickListener {
            dummy_click.background = getDrawable(R.drawable.custom_ripple_border)
            println("DEBUG check here..........")
        }

        dummy_click4.setOnClickListener {
            dummy_click4.background = getDrawable(R.drawable.custom_ripple_borderless)
        }


    }

}