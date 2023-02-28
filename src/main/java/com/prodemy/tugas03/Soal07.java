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
        String daftarBarang[][] = {
            {"Oreo", "6000"},
            {"Tanggo", "5000"},
            {"Buavita", "7000"},
            {"Aqua", "3000"},};
        int hargaMaks = Integer.parseInt(daftarBarang[0][1]);
        String barangMaks = "";
        Scanner scan = new Scanner(System.in);
        System.out.print("Masukkan modal awal: ");
        int modal = scan.nextInt();

        for (int i = 0; i < daftarBarang.length - 1; i++) {
            hargaMaks = Integer.parseInt(daftarBarang[i][1]);
            if (hargaMaks <= modal) {
                if (hargaMaks < Integer.parseInt(daftarBarang[i + 1][1])) {
                    hargaMaks = Integer.parseInt(daftarBarang[i + 1][1]);
                    barangMaks = daftarBarang[i + 1][0];
                }
            } else {
                System.out.println("Modal tidak cukup");
            }
        }
        System.out.println("");
        if (modal >= hargaMaks) {
            System.out.printf("barang termahal yang dapat dibeli = %s dengan harga %d", barangMaks, hargaMaks);
        } else {
            System.out.println("Modal tidak cukup");
        }
    }
}
