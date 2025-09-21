package com.example.demo.model;


import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "novcanici")
public class Novcanik {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String naziv;

    @Column(nullable = false)
    private BigDecimal pocetnoStanje;
    
    @Column(nullable = false)
    private BigDecimal trenutnoStanje;

    private LocalDate datumKreiranja;

    private boolean stedni;
    private boolean arhiviran;

    // Relacija Many-to-One: Mnogo novčanika pripada jednom korisniku
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "korisnik_id", nullable = false)
    private Korisnik korisnik;
    
    // Relacija Many-to-One: Mnogo novčanika koristi jednu valutu
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "valuta_id", nullable = false)
    private Valuta valuta;

    // Getteri i setteri
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public BigDecimal getPocetnoStanje() {
        return pocetnoStanje;
    }

    public void setPocetnoStanje(BigDecimal pocetnoStanje) {
        this.pocetnoStanje = pocetnoStanje;
    }

    public BigDecimal getTrenutnoStanje() {
        return trenutnoStanje;
    }

    public void setTrenutnoStanje(BigDecimal trenutnoStanje) {
        this.trenutnoStanje = trenutnoStanje;
    }

    public LocalDate getDatumKreiranja() {
        return datumKreiranja;
    }

    public void setDatumKreiranja(LocalDate datumKreiranja) {
        this.datumKreiranja = datumKreiranja;
    }

    public boolean isStedni() {
        return stedni;
    }

    public void setStedni(boolean stedni) {
        this.stedni = stedni;
    }

    public boolean isArhiviran() {
        return arhiviran;
    }

    public void setArhiviran(boolean arhiviran) {
        this.arhiviran = arhiviran;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public Valuta getValuta() {
        return valuta;
    }

    public void setValuta(Valuta valuta) {
        this.valuta = valuta;
    }
}