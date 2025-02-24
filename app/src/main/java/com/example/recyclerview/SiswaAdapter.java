package com.example.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class SiswaAdapter extends RecyclerView.Adapter<SiswaAdapter.RCviewholder> {

    private ArrayList<Siswa> siswaList;

    public SiswaAdapter(ArrayList<Siswa> siswaList) {
        this.siswaList = siswaList;
    }

    @NonNull
    @Override
    public RCviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_siswa, parent, false);
        return new RCviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RCviewholder holder, int position) {
        Siswa siswa = siswaList.get(position);
        holder.rc_Nama.setText(siswa.getNama());
        holder.rc_Absen.setText(siswa.getNomorAbsen());
        holder.rc_Avatar.setImageResource(siswa.getAvatar());
    }

    @Override
    public int getItemCount() {
        return siswaList.size();
    }

    public class RCviewholder extends RecyclerView.ViewHolder {
        TextView rc_Nama;
        TextView rc_Absen;
        ImageView rc_Avatar;

        public RCviewholder(@NonNull View itemView){
            super(itemView);
            rc_Nama = itemView.findViewById(R.id.rc_nama);
            rc_Absen = itemView.findViewById(R.id.rc_absen);
            rc_Avatar = itemView.findViewById(R.id.rc_image);
        }
    }
}
