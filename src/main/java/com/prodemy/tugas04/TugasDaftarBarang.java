/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prodemy.tugas04;

import java.util.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rizqi Ahmad Abdillah
 */
public class TugasDaftarBarang {

    public static void main(String[] args) {
        Barang barang = new Barang("Oreo", 6000, 3);
        Barang barang2 = new Barang("Tanggo", 5000, 4);
        Barang barang3 = new Barang("Buavita", 7000, 2);
        Barang barang4 = new Barang("Aqua", 3000, 5);

        try {
//            creating file
            File file = new File("file.txt");
            if (file.createNewFile()) {
                System.out.println("File created!");
            } else {
                System.err.println("File already exists!");
            }
//            writing objects to file
            FileOutputStream f = new FileOutputStream(file);
            ObjectOutputStream o = new ObjectOutputStream(f);
            o.writeObject(barang);
            o.writeObject(barang2);
            o.writeObject(barang3);
            o.writeObject(barang4);
            o.close();
            f.close();
//            printing file
            FileInputStream fi = new FileInputStream(file);
            ObjectInputStream oi = new ObjectInputStream(fi);
            Barang br = (Barang) oi.readObject();
            Barang br2 = (Barang) oi.readObject();
            Barang br3 = (Barang) oi.readObject();
            Barang br4 = (Barang) oi.readObject();

            System.out.println(br.toString());
            System.out.println(br2.toString());
            System.out.println(br3.toString());
            System.out.println(br4.toString());
        } catch (IOException ex) {
            Logger.getLogger(TugasDaftarBarang.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TugasDaftarBarang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
