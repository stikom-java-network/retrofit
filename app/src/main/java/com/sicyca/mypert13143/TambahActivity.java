package com.sicyca.mypert13143;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sicyca.mypert13143.config.InitService;
import com.sicyca.mypert13143.model.Crud;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TambahActivity extends AppCompatActivity {

    private EditText et_judul, et_genre, et_tahun, et_durasi;
    private Button bt_simpan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Tambah Data Film");

        et_judul = findViewById(R.id.edit_judul);
        et_genre = findViewById(R.id.edit_genre);
        et_tahun = findViewById(R.id.edit_tahun);
        et_durasi = findViewById(R.id.edit_durasi);
        bt_simpan = findViewById(R.id.btn_simpan);

        bt_simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String judul = et_judul.getText().toString();
                String genre = et_genre.getText().toString();
                String tahun = et_tahun.getText().toString();
                String durasi = et_durasi.getText().toString();

                if(judul.isEmpty() || genre.isEmpty() || tahun.isEmpty() || durasi.isEmpty()){
                    Toast.makeText(TambahActivity.this, "Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
                }else if(tahun.length() > 4){
                    Toast.makeText(TambahActivity.this, "panjang tahun tidak boleh lebih dari 4 digit", Toast.LENGTH_SHORT).show();
                }else{
                    Call<Crud> call = InitService.getInstance().postFilm(judul,genre,tahun,Integer.parseInt(durasi),"default.jpg");
                    call.enqueue(new Callback<Crud>() {
                        @Override
                        public void onResponse(Call<Crud> call, Response<Crud> response) {
                            Toast.makeText(TambahActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                            setResult(1);
                            finish();
                        }

                        @Override
                        public void onFailure(Call<Crud> call, Throwable t) {
                            Log.d("Error", "tambahFilm: " + t.getMessage());
                        }
                    });
                }
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
