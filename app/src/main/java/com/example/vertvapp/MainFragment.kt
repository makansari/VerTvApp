package com.example.vertvapp

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Website.URL
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.leanback.app.BrowseSupportFragment
import androidx.leanback.widget.*
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso
import java.net.URL


class MainFragment : BrowseSupportFragment(), OnItemViewClickedListener {


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setOnItemViewClickedListener(this)
        setUi()
        loadRows()
    }

    private fun loadRows() {
        var cat1 = HeaderItem(0, "MOVIES")
        var cat2 = HeaderItem(1, "SPORTS")

        var adapterForRow1 = ArrayObjectAdapter(MyPresenter2())
        adapterForRow1.add(
            SingleRowViewData(
                "MOVIE ONE",
                "https://www.shorturl.at/img/shorturl-square.png"
            )
        )
        adapterForRow1.add(
            SingleRowViewData(
                "MOVIE TWO",
                "https://homepages.cae.wisc.edu/~ece533/images/airplane.png"
            )
        )
        adapterForRow1.add(
            SingleRowViewData(
                "MOVIE THREE",
                "https://homepages.cae.wisc.edu/~ece533/images/airplane.png"
            )
        )
        adapterForRow1.add(
            SingleRowViewData(
                "MOVIE FOUR",
                "https://homepages.cae.wisc.edu/~ece533/images/airplane.png"
            )
        )

        var adapterForRow2 = ArrayObjectAdapter(MyPresenter2())
        adapterForRow2.add(
            SingleRowViewData(
                "Mera naam",
                "https://homepages.cae.wisc.edu/~ece533/images/airplane.png"
            )
        )
        adapterForRow2.add(
            SingleRowViewData(
                "Anamika",
                "https://homepages.cae.wisc.edu/~ece533/images/airplane.png"
            )
        )
        adapterForRow2.add(
            SingleRowViewData(
                "SpiderMan",
                "https://homepages.cae.wisc.edu/~ece533/images/airplane.png"
            )
        )
        adapterForRow2.add(
            SingleRowViewData(
                "IronMan",
                "https://homepages.cae.wisc.edu/~ece533/images/airplane.png"
            )
        )
        adapterForRow2.add(
            SingleRowViewData(
                "SuperMna",
                "https://homepages.cae.wisc.edu/~ece533/images/airplane.png"
            )
        )
        adapterForRow2.add(
            SingleRowViewData(
                "SpiderMan",
                "https://homepages.cae.wisc.edu/~ece533/images/airplane.png"
            )
        )
        var adapterForWindow1 = ArrayObjectAdapter(ListRowPresenter())

        adapterForWindow1.add(ListRow(cat1, adapterForRow1))
        adapterForWindow1.add(ListRow(cat2, adapterForRow2))
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
        var i = Intent(activity, DetailsActivity::class.java)
        i.putExtra("key", itemData)
        i.putExtra("image",item.image )
        Toast.makeText(activity, "You clicked : " + itemData, Toast.LENGTH_LONG).show()
        startActivity(i)
    }
}

/*class MyPresentClass : Presenter() {

    private var myImageCardView: ImageCardView? = null
    private var imageView: ImageView?= null
    override fun onCreateViewHolder(parent: ViewGroup?): ViewHolder {
        //myImageCardView = ImageCardView(parent?.context)
        myImageCardView = object : ImageCardView(parent!!.context) {
            override fun setSelected(selected: Boolean) {
                super.setSelected(selected)
            }
        }
        imageView = ImageView(parent?.context)
        myImageCardView?.cardType = BaseCardView.CARD_TYPE_INFO_UNDER_WITH_EXTRA
        myImageCardView?.infoVisibility = BaseCardView.CARD_REGION_VISIBLE_ACTIVATED

        return ViewHolder(myImageCardView)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder?, item: Any?) {

        var srvd = item as SingleRowViewData
        var icv = viewHolder?.view as ImageCardView


//       This is for hardcoded images
//        var setImage = icv.setMainImage(srvd.image)
//        icv.setMainImageDimensions(313, 176)

        icv.titleText = srvd.name
        icv.contentText= "This is movies list..."

        icv.setMainImageDimensions(313, 176)
        Glide.with(viewHolder.view.context).load(URL(item.image)).error(R.drawable.abc).centerCrop().into(icv.mainImageView)
        //Picasso.get().load(item.image).resize(313, 176).centerCrop().into(icv.mainImageView)



    }

    override fun onUnbindViewHolder(viewHolder: ViewHolder?) {
    }

}*/
