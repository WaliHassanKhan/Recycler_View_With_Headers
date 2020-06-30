package com.example.recyclerviewwithheader

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        var main_dict:HashMap<String,MutableList<String>> = HashMap<String,MutableList<String>>()
        main_dict.set("header1",mutableListOf("alpha","beta","gamma"))
        main_dict.set("header2",mutableListOf("delta","peta","omega"))
        var temp_list:MutableList<List<String>> = mutableListOf()
        for((key,value) in main_dict){
            temp_list.add(listOf("head",key))
            for(one in value){
                temp_list.add(listOf("bod",one))
            }
        }
        recycler_view_id.layoutManager = LinearLayoutManager(this)
        fun clicker(input:String){
            Log.d("alphaclick",input)
        }
        recycler_view_id.adapter = data_adapter(temp_list,{input:String->clicker(input)})
    }
}