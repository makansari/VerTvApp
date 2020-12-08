package com.example.vertvapp

import android.media.session.PlaybackState.ACTION_PLAY
import android.media.session.PlaybackState.ACTION_REWIND
import android.os.Bundle
import androidx.leanback.app.DetailsSupportFragment
import androidx.leanback.media.PlaybackBannerControlGlue
import androidx.leanback.widget.*

class DetailsFragment : DetailsSupportFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        buildUI()
    }

  private fun buildUI() {
     var selector = ClassPresenterSelector()
    selector.addClassPresenter(DetailsOverviewRow::class.java, FullWidthDetailsOverviewRowPresenter(MyDetailsPresenter()))


      var arrobjAdp = ArrayObjectAdapter(selector)
      var detailsOverview = DetailsOverviewRow("my media objects")
      detailsOverview.imageDrawable = this.resources.getDrawable(R.drawable.abc)

      var actionAdpt = SparseArrayObjectAdapter()
      actionAdpt.set(ACTION_PLAY.toInt(),Action(1,"BUY -- 500 rs"))
      actionAdpt.set(ACTION_REWIND.toInt(),Action(2, "RENT -- 100 rs "))

      detailsOverview.actionsAdapter = actionAdpt
      arrobjAdp.add(detailsOverview)
      adapter = arrobjAdp

  }
 }


