package com.Nemanja.finansije.model;


import java.math.BigDecimal;
import java.time.LocalDate;

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
@Table(name = "transakcije")
public class Transakcija {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String naziv;
    
    @Column(nullable = false)
    private BigDecimal iznos;
    
    @Enumerated(EnumType.STRING)
    private TipKategorije tip; // Ista enumeracija kao i u Kategorija

    private LocalDate datumTransakcije;

    private boolean ponavljajuca;

    @Enumerated(EnumType.STRING)
    private Ucestalost ucestalost; // Kreirati novi enum
    
    // Relacije Many-to-One
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "kategorija_id", nullable = false)
    private Kategorija kategorija;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "novcanik_id", nullable = false)
    private Novcanik novcanik;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "korisnik_id", nullable = false)
    private Korisnik korisnik;

    // Getteri i setteri
    // ...
}


