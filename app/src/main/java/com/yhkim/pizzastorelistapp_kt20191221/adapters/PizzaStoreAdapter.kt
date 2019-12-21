package com.yhkim.pizzastorelistapp_kt20191221.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
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

        pizzaNm.text = data.storeName

        return row

    }
}