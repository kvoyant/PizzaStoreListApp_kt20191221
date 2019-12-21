package com.yhkim.pizzastorelistapp_kt20191221

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yhkim.pizzastorelistapp_kt20191221.adapters.PizzaStoreAdapter
import com.yhkim.pizzastorelistapp_kt20191221.datas.PizzaStore

class MainActivity : BaseActivity() {

    var pizzaStoreList = ArrayList<PizzaStore>()

    var pizzaStoreAdapter:PizzaStoreAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {
    }

    override fun setValues() {
        addPizzaStores()

        pizzaStoreAdapter = PizzaStoreAdapter(this, R.layout.pizza_list_item, pizzaStoreList)
    }

    fun addPizzaStores() {
        pizzaStoreList.add(PizzaStore("피자헛", "02-4114-4342", "https://img1.daumcdn.net/thumb/R800x0/?scode=mtistory2&fname=https%3A%2F%2Fk.kakaocdn.net%2Fdn%2FnkQca%2FbtqwVT4rrZo%2FymhFqW9uRbzrmZTxUU1QC1%2Fimg.jpg"))
    }
}
