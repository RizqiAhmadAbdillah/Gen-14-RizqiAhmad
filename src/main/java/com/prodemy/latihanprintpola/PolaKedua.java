/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prodemy.latihanprintpola;

/**
 *
 * @author Rizqi Ahmad Abdillah
 */
public class PolaKedua extends Pola{
    @Override
    public void printPolaDua(int n, int m){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i==j||i+j==n-1) {
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }
        System.out.println("");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (i==j||i+j==m-1) {
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }
    }
}
