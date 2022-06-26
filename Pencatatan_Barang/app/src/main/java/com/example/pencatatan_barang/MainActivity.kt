package com.example.pencatatan_barang

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private val api by lazy { RetrofitKoneksi().endpoint}
    private lateinit var viewAdater: AdapterMain
    private lateinit var listNote: RecyclerView
    private lateinit var btnTambah : ExtendedFloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)
        setupView()
        setupList()
        setupListener()

    }

    override fun onStart() {
        super.onStart()
        getData()
    }

    private fun setupView() {
        listNote = findViewById(R.id.recyclerView)
        btnTambah = findViewById(R.id.btn_tambah)
    }

    private fun setupListener() {
        btnTambah.setOnClickListener {
            startActivity(Intent(this,CreateActivity::class.java))
        }
    }

    private fun setupList() {
        viewAdater = AdapterMain(arrayListOf(), object : AdapterMain.OnAdapterListener{
            override fun onUpdate(hasil: ListData.Data) {
                startActivity(
                    Intent(this@MainActivity,EditActivitiy::class.java)
                        .putExtra("note",hasil)
                )
            }

            override fun onDelete(hasil: ListData.Data) {
                api.hapus(hasil.id!!)
                    .enqueue(object : Callback<ResponInput>{
                        override fun onResponse(
                            call: Call<ResponInput>,
                            response: Response<ResponInput>
                        ) {
                            if (response.isSuccessful){
                                val submit = response.body()
                                Toast.makeText(applicationContext,submit!!.pesan, Toast.LENGTH_SHORT).show()
                                getData()
                            }
                        }

                        override fun onFailure(call: Call<ResponInput>, t: Throwable) {
                        }

                    })
            }

        })
        listNote.adapter = viewAdater
    }

    private fun getData() {
        api.data().enqueue(object : Callback<ListData> {
            override fun onResponse(call: Call<ListData>, response: Response<ListData>) {
                if (response.isSuccessful) {
                    val listData = response.body()!!.hasil

                    //menampilkan data mysql di layout
                    viewAdater.setData(listData)

                }
            }

            override fun onFailure(call: Call<ListData>, t: Throwable) {
                Log.e("MainActivity-Log", t.toString())
            }

        })
    }
}