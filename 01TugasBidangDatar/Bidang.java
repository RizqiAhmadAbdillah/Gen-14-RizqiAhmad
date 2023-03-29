/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prodemy.tugas01;

/**
 *
 * @author Rizqi Ahmad Abdillah
 */
public abstract class Bidang {

    public String nama;
    public float luas, keliling;

    public Bidang() {
    }

    public Bidang(String nama, float luas, float keliling) {
        this.nama = nama;
        this.luas = luas;
        this.keliling = keliling;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }
    
    public String hitungKeliling(){
        return "";
    }
    
    public String hitungLuas(){
        return "";
    }
}
