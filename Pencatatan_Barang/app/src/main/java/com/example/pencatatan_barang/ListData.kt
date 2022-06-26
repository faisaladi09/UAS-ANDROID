package com.example.pencatatan_barang

import java.io.Serializable

data class ListData (
    val hasil : List<Data>
){
    data class Data(
        val id:String?,
        val kd_barang:String?,
        val nm_barang:String?,
        val keterangan:String?
    ): Serializable
}