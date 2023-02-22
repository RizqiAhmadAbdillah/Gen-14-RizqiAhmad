/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prodemy.latihanprintpola;

/**
 *
 * @author Rizqi Ahmad Abdillah
 */
public class PolaKetiga extends Pola {

    @Override
    public void printPola(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(j);
            }
            System.out.println("");
        }
    }
}
