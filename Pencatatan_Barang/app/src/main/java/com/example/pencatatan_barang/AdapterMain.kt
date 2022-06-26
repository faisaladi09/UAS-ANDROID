package com.example.pencatatan_barang

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterMain(
    val hasil: ArrayList<ListData.Data>,
    val listener: OnAdapterListener

):RecyclerView.Adapter<AdapterMain.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.activity_adapter_main, parent, false)
    )

    override fun getItemCount():Int {
        return hasil.size
        //return body.size
    }

    override fun onBindViewHolder(holder: AdapterMain.ViewHolder, position: Int) {
        val data = hasil[position]

        holder.view.findViewById<TextView>(R.id.tv_NmBarang).text = data.kd_barang
        holder.view.findViewById<TextView>(R.id.tv_Catatan).text = data.nm_barang
        holder.view.findViewById<TextView>(R.id.tv_tgl).text = data.keterangan

        holder.view.findViewById<TextView>(R.id.btn_update).setOnClickListener{
            listener.onUpdate(data)
        }

        holder.view.findViewById<TextView>(R.id.btn_delete).setOnClickListener{
            listener.onDelete(data)
        }
    }
    class ViewHolder(val view: View): RecyclerView.ViewHolder(view)

    public fun setData(data: List<ListData.Data>){
        hasil.clear()
        hasil.addAll(data)
        notifyDataSetChanged()
    }

    interface OnAdapterListener{
        fun onUpdate(hasil: ListData.Data)
        fun onDelete(hasil: ListData.Data)
    }
}