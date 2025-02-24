package com.example.recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class activity_detail extends AppCompatActivity {

    TextView tvNama, tvNamaLengkap, tvKelas, tvAbsen, tvGender;
    ImageView imgAvatar;


;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail);

        tvNama = findViewById(R.id.detailJudul);
        tvNamaLengkap = findViewById(R.id.detailAddress);
        imgAvatar  = findViewById(R.id.detailGambar);
        tvKelas = findViewById(R.id.detailkElas);
        tvAbsen = findViewById(R.id.detailaBsen);
        tvGender = findViewById(R.id.detailGender);

        Intent intent = getIntent();
        String nama = intent.getStringExtra("Nama");
        String namaLengkap = intent.getStringExtra("Nama Lengkap");
        String kelas = intent.getStringExtra("Kelas");
        String absen = intent.getStringExtra("Absen");
        String gender = intent.getStringExtra("Gender");
        int avatar = intent.getIntExtra("Avatar", R.drawable.orangs);

        tvNama.setText(nama);
        tvNamaLengkap.setText(namaLengkap);
        tvKelas.setText(kelas);
        tvAbsen.setText(absen);
        tvGender.setText(gender);
        imgAvatar.setImageResource(avatar);






    }
}