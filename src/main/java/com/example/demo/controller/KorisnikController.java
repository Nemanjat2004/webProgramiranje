package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.model.Korisnik;
import com.example.demo.repository.KorisnikRepository; // Uverite se da je import ispravan
import com.example.demo.service.KorisnikService;

import java.util.List;

@RestController
@RequestMapping("/api/korisnici")
public class KorisnikController {

    @Autowired
    private KorisnikService korisnikService;

    @Autowired
    private KorisnikRepository korisnikRepository;

    @PostMapping
    public Korisnik kreirajKorisnika(@RequestBody Korisnik korisnik) {
        return korisnikService.sacuvajKorisnika(korisnik);
    }

    @GetMapping
    public List<Korisnik> getSviKorisnici() {
        return korisnikRepository.findAll();
    }

    @GetMapping("/broj")
    public long getBrojKorisnika() {
        return korisnikRepository.count();
    }

    

}