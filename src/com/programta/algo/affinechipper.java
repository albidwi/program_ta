/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.programta.algo;

/**
 *
 * @author user
 */
public class affinechipper {

//encyption method
public String enkripsi(String pesan, int k1, int k2){

    //change text message into array
    char[] chars = pesan.toCharArray();

    //getting ASCII code from each characters index
    int[] ascii = new int[chars.length];
    for (int i = 0; i < chars.length; i++) {
        ascii[i] = (int) chars[i];
    }

    //Affine encryption formula
    int[] c = new int[ascii.length];
    for (int j = 0; j < ascii.length; j++) {
        c[j] = ((k1*ascii[j])+k2) % 256;
    }

    //change the decimal (ASCII code) value back to characters
    char[] charen = new char[c.length];
    for (int i = 0; i < c.length; i++) {
        charen[i] = (char)c[i];
    }

    //change characters to String
    String pesan_en = String.valueOf(charen);
    return pesan_en;
}
public String dekripsi(String isipesanMasuk, int k1, int k2){
    int j,g;
    int[] c;
    int[] f = new int [256];

    //change text message into array    
    char[] chars = isipesanMasuk.toCharArray();

    //getting ASCII code from each characters index
    int[] ascii = new int[chars.length];
    for (int i = 0; i < chars.length; i++) {
        ascii[i] = (int) chars[i];
    }


    //getting inverse from encryption formula of Affine
    //example 33f = 1 (mod) 224 -> f = (1+(224 * j)) / 5
    //g = (33 * f) mod 224
    //if g = 1 then stop
    for (j = 1; j < 256; j++) {
            f[j] = (1 +(256*j)) / k1;
            g = (k1*f[j]) % 256 ;
        if (g==1) {
            break;
        }
    }

    //Affine decrypion formula      
    c = new int[ascii.length];
    for (int k = 0; k < ascii.length; k++) {
      c[k] = (f[j]*(ascii[k]-k2+256)) % 256;
    }

    //change the decimal (ASCII code) value back to characters          
    char[] charde = new char[c.length];
    for (int i = 0; i < c.length; i++) {
        charde[i] = (char)c[i];
    }   

    //change characters to String
    String pesan_de = String.valueOf(charde);
    return pesan_de;
}   
}
