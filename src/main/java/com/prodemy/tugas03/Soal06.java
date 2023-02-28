/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prodemy.tugas03;


/**
 *
 * @author Rizqi Ahmad Abdillah
 */
public class Soal06 {

    public static void main(String[] args) {
        String kalimat = "Aku belajar pemrograman";
        int countA = 0, countE = 0, countI = 0, countO = 0, countU = 0;
//        char arrayVokal[] = {'a','i','u','e','o'};
//        List<Character> kumpulanVokal = new ArrayList<>();
        for (int i = 0; i < kalimat.length(); i++) {
            switch (Character.toLowerCase(kalimat.charAt(i))) {
                case 'a' -> countA++;
                case 'e' -> countE++;
                case 'i' -> countI++;
                case 'o' -> countO++;
                case 'u' -> countU++;
                default -> {}
            }
        }
        System.out.println("Soal no.6");
        System.out.printf("\na = %d", countA);
        System.out.printf("\ne = %d", countE);
        System.out.printf("\ni = %d", countI);
        System.out.printf("\no = %d", countO);
        System.out.printf("\nu = %d", countU);
    }
}
