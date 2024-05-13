package com.aplikacja.model;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "szczegolyZamowienia")
public class szczegolyZamowienia implements Serializable {

    private static final long serialVersionUID = -3009157732242241606L;

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int id;

    @Column (name = "idZamowienie")
    private int idZamowienie;

    @Column (name = "idProdukt")
    private int idProdukt;
    
    @Column (name = "ilosc")
    private int ilosc;


    public szczegolyZamowienia    () {};
    //Konstruktor stosowany do tworzenia nowych produktow w bazie
    public szczegolyZamowienia    (int idZamowienie, int idProdukt, int ilosc) {
        this.setIdZamowienie (idZamowienie);
        this.setIdProdukt (idProdukt);
        this.setIlosc (ilosc);
    }
    //Konstruktor stosowany do edytowania istniejących produktow w bazie
    public szczegolyZamowienia    (int id, int idZamowienie, int idProdukt, int ilosc) {
        this.setId(id);
        this.setIdZamowienie (idZamowienie);
        this.setIdProdukt (idProdukt);
        this.setIlosc (ilosc);
    }
    public int getId() {
        return id;
    }
    public void setId (int id) {
        this.id = id;
    }
    public int getIdZamowienie () {
        return idZamowienie;
    }
    public void setIdZamowienie (int idZamowienie) {
        this.idZamowienie = idZamowienie;
    }
    public int getIdProdukt () {
        return idProdukt;
    }
    public void setIdProdukt (int idProdukt) {
        this.idProdukt = idProdukt;
    }
    public int getIlosc () {
        return ilosc;
    }
    public void setIlosc (int ilosc) {
        this.ilosc = ilosc;
    }
    
    @Override
    public String toString () {
        return "Produkt (" +
            "id=" + id +
            ", idZamowienie ='" + idZamowienie + '\"' +
            ", idProdukt ='" + idProdukt  + '\"' +
            ", ilosc='" + ilosc + '\"' +
            ')';
    }
}

