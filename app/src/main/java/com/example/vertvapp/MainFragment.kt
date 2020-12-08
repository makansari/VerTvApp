package com.example.vertvapp

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Toast
import androidx.leanback.app.BrowseSupportFragment
import androidx.leanback.widget.*

class MainFragment : BrowseSupportFragment(), OnItemViewClickedListener {


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setOnItemViewClickedListener(this)
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

        var adapterForRow2 = ArrayObjectAdapter(MyPresentClass())
        adapterForRow2.add(SingleRowViewData("Mera naam", context?.resources!!.getDrawable(R.drawable.sce1)))
        adapterForRow2.add(SingleRowViewData("Anamika", context?.resources!!.getDrawable(R.drawable.sce3)))
        adapterForRow2.add(SingleRowViewData("SpiderMan", context?.resources!!.getDrawable(R.drawable.sce3)))
        adapterForRow2.add(SingleRowViewData("IronMan", context?.resources!!.getDrawable(R.drawable.sce1)))
        adapterForRow2.add(SingleRowViewData("SuperMna", context?.resources!!.getDrawable(R.drawable.abc)))
        adapterForRow2.add(SingleRowViewData("SpiderMan", context?.resources!!.getDrawable(R.drawable.sce1)))
        var adapterForWindow1 = ArrayObjectAdapter(ListRowPresenter())

        adapterForWindow1.add(ListRow(cat1,adapterForRow1))
        adapterForWindow1.add(ListRow(cat2,adapterForRow2))
        adapter = adapterForWindow1
    }

    private fun setUi() {

        title = "LG"
        headersState = HEADERS_ENABLED
        brandColor = Color.GREEN
    }

    override fun onItemClicked(
        itemViewHolder: Presenter.ViewHolder?,
        item: Any?,
        rowViewHolder: RowPresenter.ViewHolder?,
        row: Row?
    ) {
        var myItem =   item as SingleRowViewData
        var itemData = item.name
        var i = Intent(activity,DetailsActivity::class.java)
        i.putExtra("key",itemData)
        Toast.makeText(activity,"You clicked : " + itemData,Toast.LENGTH_LONG).show()
        startActivity(i)
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
