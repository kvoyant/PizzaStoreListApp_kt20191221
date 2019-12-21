package com.yhkim.pizzastorelistapp_kt20191221

import android.Manifest
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.TedPermission
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

        callBtn.setOnClickListener {
            val listener = object : PermissionListener {
                override fun onPermissionGranted() {
                    var uri = Uri.parse("tel:${mPizzaStoreData?.phoneNum}")
                    val intent  = Intent(Intent.ACTION_CALL, uri)
                    startActivity(intent)
                }

                override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {
                    Toast.makeText(mContext, "전화 권한을 허용해야 걸 수 있습니다.", Toast.LENGTH_SHORT).show()
                }

            }
            TedPermission.with(mContext)
                .setPermissionListener(listener)
                .setDeniedMessage("권한설정이 필요합니다.")
//                .setRationaleMessage("바로 전화를 걸기 위해 필요합니다.")
                .setPermissions(Manifest.permission.CALL_PHONE)
                .check()

        }
    }

    override fun setValues() {
        mPizzaStoreData = intent.getSerializableExtra("pizzaStoreData") as PizzaStore

        pizzaStoreNmTxt.text = mPizzaStoreData?.storeName
        pizzaStoreTelTxt.text = mPizzaStoreData?.phoneNum
        Glide.with(mContext).load(mPizzaStoreData?.logoUrl).into(logoImgDetail)

    }

}
