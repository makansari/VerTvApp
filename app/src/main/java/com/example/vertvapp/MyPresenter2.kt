package com.example.vertvapp

import android.graphics.drawable.Drawable
import android.util.Log
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.leanback.widget.BaseCardView
import androidx.leanback.widget.ImageCardView
import androidx.leanback.widget.Presenter
import com.bumptech.glide.Glide
import java.net.URL

class MyPresenter2 :Presenter() {

    /*private var myImageCardView: ImageCardView? = null
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
        Log.i("tag" , "url received is : " + item.image)
        Glide.with(viewHolder.view.context).load(URL(item.image)).error(R.drawable.abc).centerCrop().into(icv.mainImageView)
        //Picasso.get().load(item.image).resize(313, 176).centerCrop().into(icv.mainImageView)



    }

    override fun onUnbindViewHolder(viewHolder: ViewHolder?) {
    }*/

    private var imageCardView: ImageCardView? = null
    private var imageView: ImageView?= null
    private var mDefaultImg: Drawable? = null
    override fun onCreateViewHolder(parent: ViewGroup?): ViewHolder {

        imageCardView = ImageCardView(parent?.context)
        imageView = ImageView(parent?.context)
        imageCardView?.cardType = BaseCardView.CARD_TYPE_INFO_UNDER_WITH_EXTRA
        imageCardView?.infoVisibility = BaseCardView.CARD_REGION_VISIBLE_ACTIVATED
        mDefaultImg = parent?.context?.let { ContextCompat.getDrawable(it, R.drawable.abc) }

        return ViewHolder(imageCardView)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder?, item: Any?) {
        val movieData = item as SingleRowViewData
        val view = viewHolder?.view as ImageCardView

        // imageCardView?.addView
        view.setMainImageDimensions(313,176)
        Log.i("mytag","image url : " + movieData.image)
        Glide.with(viewHolder.view.context).load(movieData.image)
                .centerCrop().error(mDefaultImg).into(view.mainImageView)

    }

    override fun onUnbindViewHolder(viewHolder: ViewHolder?) {
    }

}