-- Uklanjanje postojećih podataka da bi se izbeglo dupliranje pri svakom pokretanju
DELETE FROM korisnici;

-- Popunjavanje tabele 'korisnici'
INSERT INTO korisnici (id, ime, prezime, korisnicko_ime, email, lozinka, datum_rodjenja, uloga, profilna_slika_putanja, datum_registracije, blokiran)
VALUES (1, 'Petar', 'Petrovic', 'pera123', 'pera@primer.com', 'sifra123', '1990-05-15', 'KORISNIK', null, '2024-08-30', false);

-- Administrator korisnik
INSERT INTO korisnici (id, ime, prezime, korisnicko_ime, email, lozinka, datum_rodjenja, uloga, profilna_slika_putanja, datum_registracije, blokiran)
VALUES (2, 'Ana', 'Anic', 'Admin', 'ana@primer.com', '1234', '1985-02-20', 'ADMINISTRATOR', null, '2024-08-29', false);