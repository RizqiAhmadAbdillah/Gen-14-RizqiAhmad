/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prodemy.tugas01;
import java.io.IOException;
import java.util.Scanner;
/**
 *
 * @author Rizqi Ahmad Abdillah
 */
public class TugasBidangDatar {
    public static void main(String[] args) throws IOException {

        Persegi persegi = new Persegi();
        Segitiga segitiga = new Segitiga();
        Lingkaran lingkaran = new Lingkaran();
        Diamond diamond = new Diamond();
        persegi.setNama("Persegi");
        segitiga.setNama("Segitiga");
        lingkaran.setNama("Lingkaran");
        diamond.setNama("Diamond");

        Bidang[] kelilingBidangDatar = {persegi, segitiga, lingkaran, diamond};
        Bidang[] luasBidangDatar = {persegi, segitiga, lingkaran, diamond};

        System.out.println("Program Menghitung Luas & Keliling");
        System.out.println("-----------------------");
        System.out.println("1. " + persegi.getNama());
        System.out.print("Masukkan sisi persegi: ");
        persegi.setSisiPersegi(printOption());
        System.out.println("=======================");

        System.out.println("\n-----------------------");
        System.out.println("2. " + segitiga.getNama());
        System.out.print("Masukkan sisi segitiga 1: ");
        segitiga.setSisiSegitiga1(printOption());
        System.out.print("Masukkan sisi segitiga 2: ");
        segitiga.setSisiSegitiga2(printOption());
        System.out.print("Masukkan sisi segitiga 3: ");
        segitiga.setSisiSegitiga3(printOption());
        System.out.println("=======================");

        System.out.println("\n-----------------------");
        System.out.println("3. " + lingkaran.getNama());
        System.out.print("Masukkan jari-jari lingkaran: ");
        lingkaran.setJariJari(printOption());
        System.out.println("=======================");

        System.out.println("\n-----------------------");
        System.out.println("4. " + diamond.getNama());
        System.out.print("Masukkan diagonal 1: ");
        diamond.setDiagonal1(printOption());
        System.out.print("Masukkan diagonal 2: ");
        diamond.setDiagonal2(printOption());
        System.out.println("=======================");

        System.out.println("\n-----------------------");
        System.out.println("Menampilkan array keliling menggunakan looping for");
        for (Bidang dataKeliling : kelilingBidangDatar) {
            System.out.println(dataKeliling.hitungKeliling());
        }
        System.out.println("Menampilkan array luas menggunakan looping for");
        for (Bidang dataLuas : luasBidangDatar) {
            System.out.println(dataLuas.hitungLuas());
        }
    }

    public static int printOption() throws IOException {
        Scanner scan = new Scanner(System.in);
        int input;
        do {
            input = scan.nextInt();
            if (input < 0) {
                System.err.println("Data tidak boleh negatif!");
                System.out.print("Masukkan data valid (angka positif): ");
            }
        } while (input < 0);
        return input;
    }
}
