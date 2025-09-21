package com.example.demo.controller;

import com.example.demo.model.Korisnik;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/home")
    public String homePage(Model model, HttpSession session) {
        Korisnik korisnik = (Korisnik) session.getAttribute("ulogovani");
        if (korisnik == null) {
            return "redirect:/"; // ako nije ulogovan, vrati ga na login
        }
        model.addAttribute("korisnik", korisnik);
        return "home";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // uništava sesiju, tj. "odjavljuje" korisnika
        return "redirect:/"; // nakon logout-a vraća na login stranu
    }

    @GetMapping("/edit_user")
    public String editUserPage(Model model, HttpSession session) {
        Korisnik korisnik = (Korisnik) session.getAttribute("ulogovani");
        model.addAttribute("korisnik", korisnik);
        return "edit_user"; // -> edit_user.html
    }
}
