package com.yhkim.pizzastorelistapp_kt20191221.datas

import java.io.Serializable

class PizzaStore(storeName:String, phoneNum:String, logoUrl:String) : Serializable {

    var storeName = storeName
    var phoneNum = phoneNum
    var logoUrl = logoUrl

}