/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prodemy.tugas01;

/**
 *
 * @author Rizqi Ahmad Abdillah
 */
public class Segitiga extends Bidang {

    private int sisiSegitiga1, sisiSegitiga2, sisiSegitiga3;

    public Segitiga() {
    }

    public Segitiga(int sisiSegitiga1, int sisiSegitiga2, int sisiSegitiga3) {
        super();
        this.sisiSegitiga1 = sisiSegitiga1;
        this.sisiSegitiga2 = sisiSegitiga2;
        this.sisiSegitiga3 = sisiSegitiga3;
    }

    public void setSisiSegitiga1(int sisiSegitiga1) {
        this.sisiSegitiga1 = sisiSegitiga1;
    }

    public void setSisiSegitiga2(int sisiSegitiga2) {
        this.sisiSegitiga2 = sisiSegitiga2;
    }

    public void setSisiSegitiga3(int sisiSegitiga3) {
        this.sisiSegitiga3 = sisiSegitiga3;
    }

    public int getSisiSegitiga1() {
        return sisiSegitiga1;
    }

    public int getSisiSegitiga2() {
        return sisiSegitiga2;
    }

    public int getSisiSegitiga3() {
        return sisiSegitiga3;
    }

    @Override
    public String hitungKeliling() {
        int hasil = getSisiSegitiga1() + getSisiSegitiga2() + getSisiSegitiga3();
        return "Keliling " + this.nama + "\t: " + hasil;
    }

    @Override
    public String hitungLuas() {
        int s=getSisiSegitiga1() + getSisiSegitiga2() + getSisiSegitiga3();
        int hasil = (int) Math.sqrt(s * (s - getSisiSegitiga1()) * (s - getSisiSegitiga2()) * (s - getSisiSegitiga3()));;
        return "Luas " + this.nama + "\t: " + hasil;
    }
}
