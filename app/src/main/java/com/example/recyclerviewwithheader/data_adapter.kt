package com.example.recyclerviewwithheader

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.cell.view.*
import kotlinx.android.synthetic.main.header_cell.view.*

class data_adapter(val inputData:MutableList<List<String>>,val click_fun:(row_name:String)->Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        if(inputData .get(position)[0]=="head"){
            return 0
        }else{
            return 1
        }
    }

    class header_view_holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val head_text = itemView.head_text_view_id

    }
    class cell_view_holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val bod_text = itemView.cell_text_view_id

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if(viewType==0){
            return header_view_holder(LayoutInflater.from(parent.context).inflate(R.layout.header_cell,parent,false))
        }else{
            return cell_view_holder(LayoutInflater.from(parent.context).inflate(R.layout.cell,parent,false))
        }
    }
    override fun getItemCount(): Int {
        return inputData.count()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder.itemViewType==0){
            (holder as header_view_holder).head_text.text = inputData[position][1]

        }else{
            (holder as cell_view_holder).bod_text.text = inputData[position][1]
        }
    }
}

