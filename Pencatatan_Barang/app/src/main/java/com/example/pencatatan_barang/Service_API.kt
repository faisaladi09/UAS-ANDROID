package com.example.pencatatan_barang

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface Service_API {

    //List Data
    @GET("view_data.php")
    fun data() : Call<ListData>

    //Edit Data
    @FormUrlEncoded
    @POST("edit.php")
    fun edit(
        @Field("id") id: String,
        @Field("kd_barang") kd_barang: String,
        @Field("nm_barang") nm_barang: String,
        @Field("keterangan") keterangan: String
    ):Call<ResponInput>

    //Untuk Delete Data
    @FormUrlEncoded
    @POST("hapus.php")
    fun hapus(
        @Field("id") id: String,
    ):Call<ResponInput>

    //Tambah Data
    @FormUrlEncoded
    @POST("tambah.php")
    fun tambah(
        @Field("kd_barang") kd_barang: String,
        @Field("nm_barang") nm_barang: String,
        @Field("keterangan") keterangan: String
    ):Call<ResponInput>




}