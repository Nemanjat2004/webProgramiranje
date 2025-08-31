package com.Nemanja.finansije.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Nemanja.finansije.model.Korisnik;
import com.Nemanja.finansije.repository.KorisnikRepository;

@Service
public class KorisnikService {

    @Autowired
    private KorisnikRepository korisnikRepository;

    public Korisnik sacuvajKorisnika(Korisnik korisnik) {
        return korisnikRepository.save(korisnik);
    }

    // Dodajte ostale metode za poslovnu logiku
    // ...
}
