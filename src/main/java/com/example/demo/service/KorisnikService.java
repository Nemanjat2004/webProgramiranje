package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Korisnik;
import com.example.demo.repository.KorisnikRepository;

@Service
public class KorisnikService {

    @Autowired
    private KorisnikRepository korisnikRepository;

    public Korisnik sacuvajKorisnika(Korisnik korisnik) {
        return korisnikRepository.save(korisnik);
    }

    public Korisnik findByKorisnickoIme(String korisnickoIme) {
        return korisnikRepository.findByKorisnickoIme(korisnickoIme);
    }
    
}
