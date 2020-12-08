package com.example.vertvapp

import android.graphics.Color
import android.os.Bundle
import android.view.ViewGroup
import androidx.leanback.app.BrowseSupportFragment
import androidx.leanback.widget.*

class MainFragment : BrowseSupportFragment() {


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setUi()
        loadRows()
    }

    private fun loadRows() {
        var cat1 = HeaderItem(0,"MOVIES")
        var cat2 = HeaderItem(1,"SPORTS")

        var adapterForRow1 = ArrayObjectAdapter(MyPresentClass())
        adapterForRow1.add(SingleRowViewData("MOVIE ONE", context?.resources!!.getDrawable(R.drawable.abc)))
        adapterForRow1.add(SingleRowViewData("MOVIE TWO", context?.resources!!.getDrawable(R.drawable.sce3)))
        adapterForRow1.add(SingleRowViewData("MOVIE THREE", context?.resources!!.getDrawable(R.drawable.sce3)))
        adapterForRow1.add(SingleRowViewData("MOVIE FOUR", context?.resources!!.getDrawable(R.drawable.sce4)))

        var adpForWindow = ArrayObjectAdapter(ListRowPresenter())
        adpForWindow.add(ListRow(cat1,adapterForRow1))
        adapter = adpForWindow
    }

    private fun setUi() {

        title = "LG"
        headersState = HEADERS_ENABLED
        brandColor = Color.GREEN
    }
}

class MyPresentClass : Presenter() {
    override fun onCreateViewHolder(parent: ViewGroup?): ViewHolder {
        var myImageCardView = ImageCardView(parent?.context)
        myImageCardView.cardType = BaseCardView.CARD_TYPE_INFO_UNDER_WITH_EXTRA
        myImageCardView.infoVisibility = BaseCardView.CARD_REGION_VISIBLE_ACTIVATED

        return ViewHolder(myImageCardView)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder?, item: Any?) {

        var srvd = item as SingleRowViewData
        var icv = viewHolder?.view as ImageCardView

        var setImage = icv.setMainImage(srvd.image)
        icv.setMainImageDimensions(313,176)

        icv.titleText = srvd.name
        icv.contentText= "This is movies list..."
    }

    override fun onUnbindViewHolder(viewHolder: ViewHolder?) {
    }

}
