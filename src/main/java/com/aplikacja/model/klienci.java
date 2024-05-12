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
import java.time.LocalDate;

@Entity
@Table(name = "klienci")
public class klienci implements Serializable {

    private static final long serialVersionUID = -3009157732242241606L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "imie")
    private String imie;

    @Column(name = "nazwisko")
    private String nazwisko;

    @Column(name = "plec")
    private String plec;

    @Column(name = "dataUrodzenia")
    private LocalDate dataUrodzenia;

    @Column(name = "email")
    private String email;

    @Column(name = "miasto")
    private String miasto;

    @Column(name = "ulica")
    private String ulica;

    @Column(name = "numerDomu")
    private String numerDomu;

    @Column(name = "numerMieszkania")
    private String numerMieszkania;

    public klienci() {
    }

    ;


//Konstruktor stosowany do tworzenia nowych produktów w bazie
public klienci(String imie, String nazwisko, String plec, LocalDate dataUrodzenia, String email, String miasto, String ulica, String numerDomu, String numerMieszkania) {
        this.setImie(imie);
        this.setNazwisko(nazwisko);
        this.setPlec(plec);
        this.setDataUrodzenia(dataUrodzenia);
        this.setEmail(email);
        this.setMiasto(miasto);
        this.setUlica(ulica);
        this.setNumerDomu(numerDomu);
        this.setNumerMieszkania(numerMieszkania);
    }

//Konstruktor stosowany do edytowania istniejących produktów w bazie
    public klienci(int it, String imie, String nazwisko, String plec, LocalDate dataUrodzenia, String email, String miasto, String ulica, String numerDomu, String numerMieszkania) {
        this.setId(id);
        this.setImie(imie);
        this.setNazwisko(nazwisko);
        this.setPlec(plec);
        this.setDataUrodzenia(dataUrodzenia);
        this.setEmail(email);
        this.setMiasto(miasto);
        this.setUlica(ulica);
        this.setNumerDomu(numerDomu);
        this.setNumerMieszkania(numerMieszkania);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getPlec() {
        return plec;
    }

    public void setPlec(String plec) {
        this.plec = plec;
    }

    public LocalDate getDataUrodzenia() {
        return dataUrodzenia;
    }

    public void setDataUrodzenia(LocalDate dataUrodzenia) {
        this.dataUrodzenia = dataUrodzenia;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getNumerDomu() {
        return numerDomu;
    }

    public void setNumerDomu(String numerDomu) {
        this.numerDomu = numerDomu;
    }

    public String getNumerMieszkania() {
        return numerMieszkania;
    }

    public void setNumerMieszkania(String numerMieszkania) {
        this.numerMieszkania = numerMieszkania;
    }

    @Override
    public String toString() {
        return "Klienci("
                + "id=" + id
                + ", imie='" + imie + '\''
                + ", nazwisko='" + nazwisko + '\''
                + ", plec='" + plec + '\''
                + ", dataUrodzenia='" + dataUrodzenia + '\''
                + ", email='" + email + '\''
                + ", miasto='" + miasto + '\''
                + ", ulica='" + ulica + '\''
                + ", numerDomu='" + numerDomu + '\''
                + ", numerMieszkania='" + numerMieszkania + '\''
                + '}';
    }

}
