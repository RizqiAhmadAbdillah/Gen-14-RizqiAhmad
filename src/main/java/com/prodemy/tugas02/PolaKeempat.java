/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prodemy.tugas02;

/**
 *
 * @author Rizqi Ahmad Abdillah
 */
public class PolaKeempat extends Pola{
    @Override
    public void printPola(int n) {
        int angka=1;
        int angka2=17;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i==j) {
                    System.out.print(angka);
                }else if(i+j==n-1){
                    System.out.print(angka2);
                }else{
                    System.out.print(" ");
                }
            }
            angka+=2;
            angka2-=2;
            System.out.println("");
        }
    }
}
