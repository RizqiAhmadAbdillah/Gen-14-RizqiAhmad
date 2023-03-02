/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prodemy.tugas04;

import java.io.Serializable;

/**
 *
 * @author Rizqi Ahmad Abdillah
 */
class Barang implements Serializable {

    private String nama;
    private int harga;
    private int stok;

    public Barang() {
    }

    public Barang(String nama, int harga, int stok) {
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    @Override
    public String toString() {
        return "\nNama\t: " + nama + "\nHarga\t: " + harga + "\nStok\t: " + stok;
    }

}
