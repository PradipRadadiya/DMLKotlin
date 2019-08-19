package com.diamondmela.home.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.diamondmela.R
import com.diamondmela.home.model.banner.SliderImage
import kotlinx.android.synthetic.main.fragment_home_item_banner.view.*
import java.util.*

class BannerAdapter(private val list: List<SliderImage>) : PagerAdapter() {

    override fun isViewFromObject(v: View, `object`: Any): Boolean {
        // Return the current view
        return v === `object` as View
    }

    override fun getCount(): Int {
        // Count the items and return it
        return list.size
    }


    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        // Get the view from pager page layout
        val view = LayoutInflater.from(container.context)
            .inflate(R.layout.fragment_home_item_banner, container, false)

            view.imgBanner.setImageURI("http://www.diamondmela.com/media/"+list[position].imageUrl)

        // Add the view to the parent
        container.addView(view)

        // Return the view
        return view
    }

    override fun destroyItem(parent: ViewGroup, position: Int, `object`: Any) {
        // Remove the view from view group specified position
        parent.removeView(`object` as View)
    }

    // Generate random light hsv color
    private fun randomLightColor(lightPercent: Int, blackPercent: Int = 100): Int {
        // Color variance - red, green, blue etc
        val hue = Random().nextInt(361).toFloat()

        // Color light to dark - 0 light 100 dark
        val saturation = lightPercent.toFloat() / 100F

        // Color black to bright - 0 black 100 bright
        val brightness: Float = blackPercent.toFloat() / 100F

        // Transparency level, full opaque
        val alpha = 255

        // Return the color
        return Color.HSVToColor(alpha, floatArrayOf(hue, saturation, brightness))
    }
}