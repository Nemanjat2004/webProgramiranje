package com.Nemanja.finansije.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "korisnici")
public class Korisnik {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ime;
    private String prezime;

    @Column(unique = true, nullable = false)
    private String korisnickoIme;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String lozinka; // Uvek heširana

    private LocalDate datumRodjenja;

    @Enumerated(EnumType.STRING)
    private Uloga uloga; // Mora se kreirati `enum` za Uloga

    private String profilnaSlikaPutanja;

    private LocalDate datumRegistracije;

    private boolean blokiran;
    
    // Relacije sa ostalim entitetima
    @OneToMany(mappedBy = "korisnik", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Novcanik> novcanici = new HashSet<>();
    
    @OneToMany(mappedBy = "korisnik", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Transakcija> transakcije = new HashSet<>();

    // Getteri i setteri (generišite ih u IDE)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public LocalDate getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(LocalDate datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public Uloga getUloga() {
        return uloga;
    }

    public void setUloga(Uloga uloga) {
        this.uloga = uloga;
    }

    public String getProfilnaSlikaPutanja() {
        return profilnaSlikaPutanja;
    }

    public void setProfilnaSlikaPutanja(String profilnaSlikaPutanja) {
        this.profilnaSlikaPutanja = profilnaSlikaPutanja;
    }

    public LocalDate getDatumRegistracije() {
        return datumRegistracije;
    }

    public void setDatumRegistracije(LocalDate datumRegistracije) {
        this.datumRegistracije = datumRegistracije;
    }

    public boolean isBlokiran() {
        return blokiran;
    }

    public void setBlokiran(boolean blokiran) {
        this.blokiran = blokiran;
    }

    public Set<Novcanik> getNovcanici() {
        return novcanici;
    }

    public void setNovcanici(Set<Novcanik> novcanici) {
        this.novcanici = novcanici;
    }

    public Set<Transakcija> getTransakcije() {
        return transakcije;
    }

    public void setTransakcije(Set<Transakcija> transakcije) {
        this.transakcije = transakcije;
    }
}
