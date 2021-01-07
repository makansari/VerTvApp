package com.example.vertvapp

import android.content.Intent
import android.graphics.Bitmap
import android.media.session.PlaybackState.ACTION_PLAY
import android.media.session.PlaybackState.ACTION_REWIND
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toBitmap
import androidx.leanback.app.DetailsFragment
import androidx.leanback.app.DetailsFragmentBackgroundController
import androidx.leanback.app.DetailsSupportFragment
import androidx.leanback.media.PlaybackBannerControlGlue
import androidx.leanback.widget.*
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.GlideDrawable
import com.bumptech.glide.request.animation.GlideAnimation
import com.bumptech.glide.request.target.SimpleTarget
import java.net.URL

class DetailsFragment : DetailsFragment() {
    private var mSelectedMovie: String? = null
    private lateinit var selector: ClassPresenterSelector
    private lateinit var arrobjAdp: ArrayObjectAdapter
    private lateinit var mDetailsBackground: DetailsFragmentBackgroundController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mDetailsBackground = DetailsFragmentBackgroundController(this)

        mSelectedMovie = activity?.intent?.extras?.get("key") as String?
        if (mSelectedMovie != null) {
            buildUI()
        } else {
            val intent = Intent(activity, MainAct::class.java)
            startActivity(intent)
        }


    }
 // testing
    private fun buildUI() {
        selector = ClassPresenterSelector()
        selector.addClassPresenter(
            DetailsOverviewRow::class.java,
            FullWidthDetailsOverviewRowPresenter(MyDetailsPresenter())
        )


         arrobjAdp = ArrayObjectAdapter(selector)
        var detailsOverview = DetailsOverviewRow(mSelectedMovie!!)
        /////////////load pic
        Glide.with(this).load(activity?.intent?.extras?.get("image") as String)
            .centerCrop()
            .into<SimpleTarget<GlideDrawable>>(object : SimpleTarget<GlideDrawable>(274, 274) {
                override fun onResourceReady(resource: GlideDrawable,
                                             glideAnimation: GlideAnimation<in GlideDrawable>) {
                    detailsOverview.imageDrawable = resource
                    arrobjAdp.notifyArrayItemRangeChanged(0, arrobjAdp.size())
                }
            })

        var actionAdpt = SparseArrayObjectAdapter()
        actionAdpt.set(ACTION_PLAY.toInt(), Action(1, "BUY -- 500 rs"))
        actionAdpt.set(ACTION_REWIND.toInt(), Action(2, "RENT -- 100 rs "))





        detailsOverview.actionsAdapter = actionAdpt
        arrobjAdp.add(detailsOverview)
        adapter = arrobjAdp

        val detailsPresenter = FullWidthDetailsOverviewRowPresenter(MyDetailsPresenter())
        detailsPresenter.backgroundColor =
            ContextCompat.getColor(context!!, R.color.selected_background)
        detailsPresenter.isParticipatingEntranceTransition = true
        detailsPresenter.onActionClickedListener = OnActionClickedListener { action ->
            if (action.id == ACTION_PLAY || action.id == ACTION_REWIND) {
                Toast.makeText(activity, action.toString(), Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(activity, action.toString(), Toast.LENGTH_SHORT).show()
            }
        }
        selector.addClassPresenter(DetailsOverviewRow::class.java, detailsPresenter)

    }


}


