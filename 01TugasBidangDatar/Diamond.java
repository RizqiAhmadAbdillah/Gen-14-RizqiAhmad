/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prodemy.tugas01;

/**
 *
 * @author Rizqi Ahmad Abdillah
 */
public class Diamond extends Bidang {

    private int diagonal1, diagonal2;

    public Diamond() {
    }

    public Diamond(int diagonal1, int diagonal2) {
        super();
        this.diagonal1 = diagonal1;
        this.diagonal2 = diagonal2;
    }

    public void setDiagonal1(int diagonal1) {
        this.diagonal1 = diagonal1;
    }

    public void setDiagonal2(int diagonal2) {
        this.diagonal2 = diagonal2;
    }

    public int getDiagonal1() {
        return diagonal1;
    }

    public int getDiagonal2() {
        return diagonal2;
    }

    @Override
    public String hitungKeliling() {
        int x = getDiagonal1() / 2;
        int y = getDiagonal2() / 2;
        int hasil = (int) Math.sqrt((x * x) + (y * y)) * 4;
        return "Keliling " + this.nama + "\t: " + hasil;
    }

    @Override
    public String hitungLuas() {
        int hasil = getDiagonal1() * getDiagonal2() / 2;
        return "Luas " + this.nama + "\t: " + hasil;
    }
}
