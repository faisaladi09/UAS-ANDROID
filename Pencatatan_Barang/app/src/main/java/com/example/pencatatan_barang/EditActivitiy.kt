package com.example.pencatatan_barang

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.button.MaterialButton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EditActivitiy : AppCompatActivity() {
    private val api by lazy { RetrofitKoneksi().endpoint }
    private lateinit var edTgl: EditText
    private lateinit var edJudul: EditText
    private lateinit var edCatatan: EditText


    private lateinit var btnEdit: MaterialButton
    private val note by lazy {intent.getSerializableExtra("note") as ListData.Data }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)
        setupView()
        setupListener()
    }
    private fun setupView(){
        edTgl = findViewById(R.id.ed_KdBarang)
        edJudul = findViewById(R.id.ed_NmBarang)
        edCatatan = findViewById(R.id.ed_Keterangan)
        btnEdit = findViewById(R.id.btn_simpan)

        edTgl.setText(note.keterangan)
        edJudul.setText(note.kd_barang)
        edCatatan.setText(note.nm_barang)


    }
    private fun setupListener(){

        btnEdit.setOnClickListener{
            api.edit(note.id!!, edJudul.text.toString(), edCatatan.text.toString(),edTgl.text.toString() )
                .enqueue(object : Callback<ResponInput>{
                    override fun onResponse(
                        call: Call<ResponInput>,
                        response: Response<ResponInput>
                    ) {
                        if (response.isSuccessful){
                            val submit = response.body()
                            Toast.makeText(applicationContext,submit!!.pesan,Toast.LENGTH_SHORT).show()
                            finish()
                        }
                    }

                    override fun onFailure(call: Call<ResponInput>, t: Throwable) {

                    }

                })
        }
    }
}

