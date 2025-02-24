package com.example.recyclerview;

public class Siswa {
    private String nama;
    private String nomorAbsen;
    private String namaLengkap;
    private String kelas;
    private String gender;
    private int avatar;

    public Siswa(String nama, String nomorAbsen, String namaLengkap, String kelas, String genDer, int avatar) {
        this.nama = nama;
        this.nomorAbsen = nomorAbsen;
        this.namaLengkap = namaLengkap;
        this.kelas = kelas;
        this.gender = genDer;
        this.avatar = avatar;
    }

    public String getNama() {
        return nama;
    }

    public String getNomorAbsen() {
        return nomorAbsen;
    }

    public String getNamaLengkap() {
        return namaLengkap;
    }

    public String getKelas() {
        return kelas;
    }

    public String getGender() {
        return gender;
    }

    public int getAvatar() {
        return avatar;
    }
}
