package com.aplikacja.kontroler;

import com.aplikacja.model.klienci;
import com.aplikacja.repozytorium.klienciRepozytorium;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("klienci")
public class KlienciKontroler {

    @Autowired
    klienciRepozytorium klienciRepo;

    @PostMapping("/dodajTestowe")
    public String dodajDaneTestoweKlienci(){

        klienciRepo.saveAll(Arrays.asList(
                new klienci("Jan", "Kowalski", "M", LocalDate.of(1990, 5,15), "jan.kowalski@example.com", "Warszawa", "Aleje Jerozolimskie", "10", "5A"),
                new klienci("Anna", "Nowak", "F", LocalDate.of(1985, 12, 10), "anna.nowak@example.com", "Kraków", "ul. Florianska", "20", null),
                new klienci("Patryk", "Wisniewski", "M", LocalDate.of(1988, 8, 25), "patryk.wisniewski@example.com", "Gdansk", "ul. Dluga", "15", "3")));

        return "Testowe rekordy dodane!";
    }

    @GetMapping("/pokazWszystkie")
    public List<klienci> pokarzWszystkieKlienci(){
        List<klienci> listaKlienci = new ArrayList<klienci>();
        for(klienci projekt : klienciRepo.findAll()){
            listaKlienci.add(projekt) ;
        }
        return listaKlienci;
    }

    @GetMapping("/wyszukajPoId/{id}")
    public String szukajPoIdKlienci(@PathVariable("id") Integer id) {
        String result = klienciRepo.findById (id) .toString();
        return result;
    }

    @GetMapping("/szukajPoNazwie/{email}")
    public String fetchDataByNazwaKlienci(@PathVariable("email") String email) {
        for (klienci projekt: klienciRepo.findByEmail (email) ) {
            return projekt.toString ();
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public String usunPoIdKlienci(@PathVariable("id") Integer id) {
        klienciRepo.deleteById (id);
        return "Rekord usunięty";
    }

    @PostMapping("/utworz")
    public klienci utworzKlienci(@RequestBody Map<String, String> body) {
        String imie = body.get("imie");
        String nazwisko = body.get("nazwisko");
        String plec = body.get("plec");
        LocalDate dataUrodzenia = LocalDate.parse(body.get("dataUrodzenia"));
        String email = body.get("email");
        String miasto = body.get("miasto");
        String ulica = body.get("ulica");
        String numerDomu = body.get("numerDomu");
        String numerMieszkania = body.get("numerMieszkania");
        return klienciRepo.save(new klienci(imie, nazwisko, plec, dataUrodzenia, email, miasto, ulica, numerDomu, numerMieszkania) ) ;
    }

    @PutMapping ("/zmien")
    public klienci zmienKlienci(@RequestBody Map<String, String> body) {
        int klientId = Integer.parseInt(body.get("klientId"));
        String imie = body.get("imie");
        String nazwisko = body.get("nazwisko");
        String plec = body.get("plec");
        LocalDate dataUrodzenia = LocalDate.parse(body.get("dataUrodzenia"));
        String email = body.get("email");
        String miasto = body.get("miasto");
        String ulica = body.get("ulica");
        String numerDomu = body.get("numerDomu");
        String numerMieszkania = body.get("numerMieszkania");
        return klienciRepo.save(new klienci(klientId, imie, nazwisko, plec, dataUrodzenia, email, miasto, ulica, numerDomu, numerMieszkania) ) ;
    }
}
