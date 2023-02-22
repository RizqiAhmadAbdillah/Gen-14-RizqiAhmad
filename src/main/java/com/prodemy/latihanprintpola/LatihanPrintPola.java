/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.prodemy.latihanprintpola;

/**
 *
 * @author Rizqi Ahmad Abdillah
 */
public class LatihanPrintPola {

    public static void main(String[] args) {
        PolaPertama pertama=new PolaPertama();
        PolaKedua kedua=new PolaKedua();
        PolaKetiga ketiga=new PolaKetiga();
        PolaKeempat keempat=new PolaKeempat();
        pertama.printPola(9);
        System.out.println("--------------------------");
        kedua.printPolaDua(9,5);
        System.out.println("--------------------------");
        ketiga.printPola(7);
        System.out.println("--------------------------");
        keempat.printPola(9);
        System.out.println("--------------------------");
    }
}
