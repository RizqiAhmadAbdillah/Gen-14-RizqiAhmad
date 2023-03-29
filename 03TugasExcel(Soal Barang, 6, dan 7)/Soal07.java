/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prodemy.tugas03;

import java.util.*;

/**
 *
 * @author Rizqi Ahmad Abdillah
 */
public class Soal07 {

    public static void main(String[] args) {
        List<Barang> daftarBarang = new ArrayList<>();
        daftarBarang.add(new Barang("Oreo", 6000));
        daftarBarang.add(new Barang("Tanggo", 5000));
        daftarBarang.add(new Barang("Buavita", 7000));
        daftarBarang.add(new Barang("Aqua", 3000));

        Collections.sort(daftarBarang, new Comparator<Barang>() {
            @Override
            public int compare(Barang o1, Barang o2) {
                if (o1.getHarga() > o2.getHarga()) {
                    return 1;
                } else if (o1.getHarga() == o2.getHarga()) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });
        Scanner scan = new Scanner(System.in);
        System.out.print("Masukkan modal awal: ");
        int modal = scan.nextInt();

        int hargaMaks = 0;
        String barangMaks = "";
        for (Barang b : daftarBarang) {
            if (b.getHarga() <= modal) {
                hargaMaks = b.getHarga();
                barangMaks = b.getNama();
            }
        }
        System.out.println("");
        if (modal >= hargaMaks && hargaMaks > 0) {
            System.out.printf("barang termahal yang dapat dibeli = %s dengan harga %d", barangMaks, hargaMaks);
        } else {
            System.out.println("Modal tidak cukup");
        }
    }
}
