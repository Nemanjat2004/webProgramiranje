package com.Nemanja.finansije.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Nemanja.finansije.model.Korisnik;
import com.Nemanja.finansije.service.KorisnikService;

@RestController
@RequestMapping("/api/korisnici")
public class KorisnikController {

    @Autowired
    private KorisnikService korisnikService;

    @PostMapping
    public Korisnik kreirajKorisnika(@RequestBody Korisnik korisnik) {
        return korisnikService.sacuvajKorisnika(korisnik);
    }
}
