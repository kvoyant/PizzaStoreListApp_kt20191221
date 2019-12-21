package com.yhkim.pizzastorelistapp_kt20191221

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.yhkim.pizzastorelistapp_kt20191221.datas.PizzaStore
import kotlinx.android.synthetic.main.activity_pizza_store_detail.*

class PizzaStoreDetailActivity : BaseActivity() {

    var mPizzaStoreData: PizzaStore? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pizza_store_detail)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {
    }

    override fun setValues() {
        mPizzaStoreData = intent.getSerializableExtra("pizzaStoreData") as PizzaStore

        pizzaStoreNmTxt.text = mPizzaStoreData?.storeName
        pizzaStoreTelTxt.text = mPizzaStoreData?.phoneNum
        Glide.with(mContext).load(mPizzaStoreData?.logoUrl).into(logoImgDetail)

    }

}
