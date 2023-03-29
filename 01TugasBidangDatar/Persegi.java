/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prodemy.tugas01;

/**
 *
 * @author Rizqi Ahmad Abdillah
 */
public class Persegi extends Bidang {

    private int sisiPersegi;

    public Persegi() {
    }

    public Persegi(int sisi) {
        super();
        this.sisiPersegi = sisi;
    }

    public void setSisiPersegi(int sisiPersegi) {
        this.sisiPersegi = sisiPersegi;
    }

    public int getSisiPersegi() {
        return sisiPersegi;
    }

    @Override
    public String hitungKeliling() {
        int hasil = getSisiPersegi() * 4;
        return "Keliling " + this.nama + "\t: " + hasil;
    }

    @Override
    public String hitungLuas() {
        int hasil = getSisiPersegi() * getSisiPersegi();
        return "Luas " + this.nama + "\t: " + hasil;
    }
}
