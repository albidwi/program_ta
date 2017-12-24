package com.programta.entity;
// Generated Dec 21, 2017 2:58:38 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Intansi generated by hbm2java
 */
public class Intansi  implements java.io.Serializable {


     private int kdInst;
     private String namaInstansi;
     private String alamat;
     private String kontak;
     private String email;
     private Set evaluasis = new HashSet(0);
     private Set pekerjas = new HashSet(0);

    public Intansi() {
    }

	
    public Intansi(int kdInst, String namaInstansi, String alamat, String kontak, String email) {
        this.kdInst = kdInst;
        this.namaInstansi = namaInstansi;
        this.alamat = alamat;
        this.kontak = kontak;
        this.email = email;
    }
    public Intansi(int kdInst, String namaInstansi, String alamat, String kontak, String email, Set evaluasis, Set pekerjas) {
       this.kdInst = kdInst;
       this.namaInstansi = namaInstansi;
       this.alamat = alamat;
       this.kontak = kontak;
       this.email = email;
       this.evaluasis = evaluasis;
       this.pekerjas = pekerjas;
    }
   
    public int getKdInst() {
        return this.kdInst;
    }
    
    public void setKdInst(int kdInst) {
        this.kdInst = kdInst;
    }
    public String getNamaInstansi() {
        return this.namaInstansi;
    }
    
    public void setNamaInstansi(String namaInstansi) {
        this.namaInstansi = namaInstansi;
    }
    public String getAlamat() {
        return this.alamat;
    }
    
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    public String getKontak() {
        return this.kontak;
    }
    
    public void setKontak(String kontak) {
        this.kontak = kontak;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public Set getEvaluasis() {
        return this.evaluasis;
    }
    
    public void setEvaluasis(Set evaluasis) {
        this.evaluasis = evaluasis;
    }
    public Set getPekerjas() {
        return this.pekerjas;
    }
    
    public void setPekerjas(Set pekerjas) {
        this.pekerjas = pekerjas;
    }




}


