package com.aplikacja.kontroler;

import com.aplikacja.model.projektanci;
import com.aplikacja.repozytorium.projektanciRepozytorium;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("projektanci")
public class ProjektanciKontroler {
    @Autowired
    projektanciRepozytorium projektanciRepo;
    

    @PostMapping("/dodajTestowe")
    public String dodajDaneTestoweProjektanci (){

        projektanciRepo.saveAll (Arrays. asList(
                new projektanci("Anna", "Kowalska", "anna.kowalska@example.com"),
                new projektanci ("Jan", "Nowak", "jan.nowak@example.com"),
                new projektanci ("Alicja", "Jankowska", "alicja.jankowska@example.com")));

        return "Testowe rekordy dodane!";
    }
    @GetMapping("/pokazWszystkie")
    public List<projektanci> pokarzWszystkieProjektanci(){
        List<projektanci> listaprojektanci = new ArrayList<projektanci>();
        for(projektanci projekt : projektanciRepo.findAll()){
            listaprojektanci.add(projekt) ;
        }
        return listaprojektanci;
    }
    @GetMapping("/wyszukajPoId/{id}")
    public String szukajPoIdProjektanci(@PathVariable("id") Integer id) {
        String result = projektanciRepo.findById (id) .toString();
        return result;
    }
    @GetMapping("/szukajPoNazwie/{email}")
    public String fetchDataByNazwaProjektanci (@PathVariable("email") String email) {
        for (projektanci projekt: projektanciRepo.findByEmail (email) ) {
            return projekt.toString ();
        }
        return null;
    }
    @DeleteMapping("/{id}")
    public String usunPoIdProjektanci(@PathVariable("id") Integer id) {
        projektanciRepo.deleteById (id);
        return "Rekord usunięty";
    }
    @PostMapping("/utworz")
    public projektanci utworzProjektanci (@RequestBody Map<String, String> body) {
        String imie = body.get("imie");
        String nazwisko = body.get("nazwisko");
        String email = body.get("email");
        return projektanciRepo.save(new projektanci (imie, nazwisko, email) ) ;
    }
    @PutMapping ("/zmien")
    public projektanci zmienProjektanci (@RequestBody Map<String, String> body) {
        int projektanciId = Integer.parseInt(body.get("projektanciId"));
        String imie = body.get("imie");
        String nazwisko = body.get("nazwisko");
        String email = body.get("email");
        return projektanciRepo.save(new projektanci(projektanciId, imie, nazwisko, email) ) ;
    }
}
