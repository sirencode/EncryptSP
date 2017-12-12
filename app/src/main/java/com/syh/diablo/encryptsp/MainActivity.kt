package com.syh.diablo.encryptsp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_save.setOnClickListener { saveData() }
        btn_get.setOnClickListener { getData() }
    }

    fun saveData() {
        SafeSharedpreferences.saveSafeString(this, ed_key.text.toString(), ed_Value.text.toString());
    }

    fun getData() {
        tv_info.setText(SafeSharedpreferences.getSafeString(this, ed_key.text.toString(), ""));
    }
}
