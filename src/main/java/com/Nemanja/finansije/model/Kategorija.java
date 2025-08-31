package com.Nemanja.finansije.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "kategorije")
public class Kategorija {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String naziv;

    @Enumerated(EnumType.STRING)
    private TipKategorije tip; // Mora se kreirati `enum` za TipKategorije

    private boolean predefinisan;

    // Relacija Many-to-One: Kategorija može imati korisnika, ali ne mora (nullable)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "korisnik_id") // Ne mora biti nullable=false
    private Korisnik korisnik;

    // Getteri i setteri
    // ...
}


