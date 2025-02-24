package com.example.recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private SiswaAdapter siswaAdapter;
    private List<Siswa> siswaList;
    private GestureDetector mGestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.RvAbsen);
        if (recyclerView == null) {
            throw new NullPointerException("RecyclerView is null! Periksa ID di activity_main.xml.");
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        siswaList = new ArrayList<>();
        siswaList.add(new Siswa("Valorant", "Rating Usia : 16+", "Developer : Riot Game", "Genre : FPS, Action, Competitive, PvP, Tactical", "Harga Game : Free", R.drawable.valos));
        siswaList.add(new Siswa("Elden Ring", "Rating Usia : 16+", "Developer : From Software", "Genre : Souls-like, RPG, Open World, Difficult", "Harga Game : Rp. 599.000", R.drawable.elnds));
        siswaList.add(new Siswa("Tekken 8", "Rating Usia : 16+", "Developer : Bandai Namco Studios", "Genre : Fighthing, Fighthing 3D, Aksi, Adventure", "Harga Game : Rp. 699.000", R.drawable.tekken));
        siswaList.add(new Siswa("EA SPORTS FC™ 25", "Rating Usia : 3+", "Developer : EA Sport", "Genre : Sport, Simulator, Soccer, Multiplayer, Copetitive", "Harga Game : Rp. 799.000", R.drawable.fc2));
        siswaList.add(new Siswa("ARK: Survival Ascended", "Rating Usia : 16+", "Developer : Studio Wildcard", "Genre : Survival, Open World, Multiplayer, Dinosaurus, Adventure", "Harga Game : Rp. 393.250", R.drawable.ark));

        siswaAdapter = new SiswaAdapter((ArrayList<Siswa>) siswaList);
        recyclerView.setAdapter(siswaAdapter);

        mGestureDetector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }
        });

        recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
                View childView = rv.findChildViewUnder(e.getX(), e.getY());
                if (childView != null && mGestureDetector.onTouchEvent(e)) {
                    int position = rv.getChildAdapterPosition(childView);
                    Siswa siswa = siswaList.get(position);

                    Intent intent = new Intent(MainActivity.this, activity_detail.class);
                    intent.putExtra("Nama", siswa.getNama());
                    intent.putExtra("Absen", siswa.getNomorAbsen());
                    intent.putExtra("Nama Lengkap", siswa.getNamaLengkap());
                    intent.putExtra("Kelas", siswa.getKelas());
                    intent.putExtra("Gender", siswa.getGender());
                    intent.putExtra("Avatar", siswa.getAvatar());
                    startActivity(intent);

                    return true;
                }
                return false;
            }

            @Override
            public void onTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
            }
        });
    }
}