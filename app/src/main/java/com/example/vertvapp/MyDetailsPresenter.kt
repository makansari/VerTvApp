package com.example.vertvapp

import androidx.leanback.widget.AbstractDetailsDescriptionPresenter

class MyDetailsPresenter : AbstractDetailsDescriptionPresenter() {
    override fun onBindDescription(vh: ViewHolder, item: Any) {
        val movie = item as String
        vh.title.text = movie
    }
}
