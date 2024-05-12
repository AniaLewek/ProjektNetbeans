/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aplikacja.model;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table (name = "produkty")
public class produkty implements Serializable {
    private static final long serialVersionUID = -3009157732242241606L;

@Id
@GeneratedValue (strategy = GenerationType. AUTO)
private int id;

@Column(name = "kategoria")
private String kategoria;

@Column(name = "nazwa")
private String nazwa;

@Column(name = "kolor")
private String kolor;

@Column(name = "cena")
private double cena;

public produkty() {};

//Konstruktor stosowany do tworzenia nowych produktów w bazie
public produkty(String kategoria, String nazwa, String kolor, double cena) {
    this.setKategoria(kategoria);
    this.setNazwa(nazwa);
    this.setKolor(kolor);
    this.setCena(cena);
}


//Konstruktor stosowany do edytowania istniejących produktów w bazie
public produkty(int it, String kategoria, String nazwa, String kolor, double cena) {
    this.setId(id);
    this.setKategoria(kategoria);
    this.setNazwa(nazwa);
    this.setKolor(kolor);
    this.setCena(cena);
}

public int getId() {
    return id;
}

public void setId(int id) {
    this.id = id;
}

public String getKategoria() {
    return kategoria;
}

public void setKategoria(String kategoria) {
    this.kategoria = kategoria;
}

public String getNazwa() {
    return nazwa;
}

public void setNazwa(String nazwa) {
    this.nazwa = nazwa;
}

public String getKolor() {
    return kolor;
}

public void setKolor(String kolor) {
    this.kolor = kolor;
}

public double geCena() {
    return cena;
}

public void setCena(double cena) {
    this.cena = cena;
}

@Override
public String toString() {
    return "Klienci(" +
            "id=" + id +
            ", kategoria='" + kategoria + '\'' +
            ", nazwa='" + nazwa + '\'' +
            ", kolor='" + kolor + '\'' +
            ", cena='" + cena + '\'' +
            '}';
}

}

