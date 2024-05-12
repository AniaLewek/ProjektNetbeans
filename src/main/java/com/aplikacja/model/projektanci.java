package com.aplikacja.model;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "projektanci")
public class projektanci implements Serializable {

    private static final long serialVersionUID = -3009157732242241606L;

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int id;

    @Column (name = "imie")
    private String imie;

    @Column (name = "nazwisko")
    private String nazwisko;
    
    @Column (name = "email")
    private String email;

    public projektanci () {};
    //Konstruktor stosowany do tworzenia nowych produktow w bazie
    public projektanci (String imie, String nazwisko, String email) {
        this.setImie (imie);
        this.setNazwisko (nazwisko);
        this.setEmail (email);
    }
    //Konstruktor stosowany do edytowania istniejących produktow w bazie
    public projektanci (int id, String imie, String nazwisko, String email) {
        this.setId(id);
        this.setImie (imie);
        this.setNazwisko (nazwisko);
        this.setEmail (email);
    }
    public int getId() {
        return id;
    }
    public void setId (int id) {
        this.id = id;
    }
    public String getImie () {
        return imie;
    }
    public void setImie (String imie) {
        this.imie = imie;
    }
    public String getNazwisko () {
        return nazwisko;
    }
    public void setNazwisko (String nazwisko) {
        this.nazwisko = nazwisko;
    }
    public String getEmail () {
        return email;
    }
    public void setEmail (String email) {
        this.email = email;
    }
    
    @Override
    public String toString () {
        return "Produkt (" +
            "id=" + id +
            ", imie='" + imie + '\"' +
            ", nazwisko='" + nazwisko + '\"' +
            ", email='" + email + '\"' +
            ')';
    }
}