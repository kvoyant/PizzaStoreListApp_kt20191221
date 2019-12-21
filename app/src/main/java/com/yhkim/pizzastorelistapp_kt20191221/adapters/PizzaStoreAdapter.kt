package com.yhkim.pizzastorelistapp_kt20191221.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.yhkim.pizzastorelistapp_kt20191221.R
import com.yhkim.pizzastorelistapp_kt20191221.datas.PizzaStore

class PizzaStoreAdapter(context:Context, resId:Int, list:ArrayList<PizzaStore>) : ArrayAdapter<PizzaStore>(context, resId, list) {
    val mContext = context
    val mList = list
    val inf = LayoutInflater.from(mContext)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var tempRow = convertView

        if(tempRow == null) {
            tempRow = inf.inflate(R.layout.pizza_list_item, null)
        }

        val row = tempRow!!

        var data = mList.get(position)

        var pizzaNm = row.findViewById<TextView>(R.id.nameTxt)
        var logoImg = row.findViewById<ImageView>(R.id.logoImg)

        pizzaNm.text = data.storeName
        Glide.with(mContext).load(data.logoUrl).into(logoImg)

        return row

    }
}