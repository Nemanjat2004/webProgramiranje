package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller; // bitno!
import org.springframework.ui.Model; // za prosleđivanje error poruke
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Korisnik;

import com.example.demo.service.KorisnikService;

import jakarta.servlet.http.HttpSession;

@Controller
public class LogInController {

    @Autowired
    private KorisnikService userService;

    // Kada korisnik pošalje login formu
    @PostMapping("/login")
    public String login(@RequestParam String username,
                    @RequestParam String password,
                    HttpSession session,
                    Model model) {

    Korisnik korisnik = userService.findByKorisnickoIme(username);

    if (korisnik != null && korisnik.getLozinka().equals(password)) {
        session.setAttribute("ulogovani", korisnik.get()); // čuvamo korisnika u sesiji
        return "redirect:/home";
    }

    model.addAttribute("error", "Pogrešno korisničko ime ili lozinka!");
    return "login";
}

}
