/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prodemy.tugas01;

/**
 *
 * @author Rizqi Ahmad Abdillah
 */
public class Lingkaran extends Bidang {

    private float jariJari, phi = 3.14F;

    public Lingkaran() {
    }

    public Lingkaran(int jariJari) {
        super();
        this.jariJari = jariJari;
    }

    public void setJariJari(int jariJari) {
        this.jariJari = jariJari;
    }

    public float getJariJari() {
        return jariJari;
    }

    @Override
    public String hitungKeliling() {
        float hasil = this.phi * 2 * getJariJari();
        return "Keliling " + this.nama + "\t: " + hasil;
    }

    @Override
    public String hitungLuas() {
        float hasil = this.phi * getJariJari() * getJariJari();
        return "Luas " + this.nama + "\t: " + hasil;
    }
}
