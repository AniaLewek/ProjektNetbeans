package com.aplikacja.kontroler;

import com.aplikacja.model.szczegolyZamowienia;
import com.aplikacja.repozytorium.szczegolyZamowieniaRepozytorium;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("szczegolyZamowienia")
public class SzczegolyZamowieniaKontroler {
    @Autowired
    szczegolyZamowieniaRepozytorium szczegolyZamowieniaRepo;

    @PostMapping("/dodajTestowe")
    public String dodajDaneTestoweSzczegolyZamowienia (){

        szczegolyZamowieniaRepo.saveAll (Arrays. asList(
                new szczegolyZamowienia(1, 1, 2),
                new szczegolyZamowienia (1, 2, 1),
                new szczegolyZamowienia (2, 3, 2)));

        return "Testowe rekordy dodane!";
    }
    @GetMapping("/pokazWszystkie")
    public List<szczegolyZamowienia> pokarzWszystkieSzczegolyZamowienia(){
        List<szczegolyZamowienia> listaszczegolyZamowienia = new ArrayList<szczegolyZamowienia>();
        for(szczegolyZamowienia projekt : szczegolyZamowieniaRepo.findAll()){
            listaszczegolyZamowienia.add(projekt) ;
        }
        return listaszczegolyZamowienia;
    }
    @GetMapping("/wyszukajPoId/{id}")
    public String szukajPoIdSzczegolyZamowienia(@PathVariable("id") Integer id) {
        String result = szczegolyZamowieniaRepo.findById (id) .toString();
        return result;
    }
        @GetMapping("/szukajPoNazwie/{idZamowienia}")
    public String fetchDataByNazwaSzczegolyZamowienia (@PathVariable("idZamowienia") int idZamowienia) {
        for (szczegolyZamowienia projekt: szczegolyZamowieniaRepo.findByIdZamowienie (idZamowienia) ) {
            return projekt.toString ();
        }
        return null;
    }
    @DeleteMapping("/{id}")
    public String usunPoIdSzczegolyZamowienia(@PathVariable("id") Integer id) {
        szczegolyZamowieniaRepo.deleteById (id);
        return "Rekord usunięty";
    }
    @PostMapping("/utworz")
    public szczegolyZamowienia utworzSzczegolyZamowienia (@RequestBody Map<String, String> body) {
        int idZamowienie = Integer.parseInt(body.get("idZamowienie"));
        int idProdukt = Integer.parseInt(body.get("idProdukt"));
        int ilosc = Integer.parseInt(body.get("ilosc"));
        return szczegolyZamowieniaRepo.save(new szczegolyZamowienia(idZamowienie, idProdukt, ilosc));
    }
    @PutMapping ("/zmien")
    public szczegolyZamowienia zmienSzczegolyZamowienia (@RequestBody Map<String, String> body) {
        int szczegolyZamowieniaId = Integer.parseInt(body.get("szczegolyZamowieniaId"));
        int idZamowienie = Integer.parseInt(body.get("idZamowienie"));
        int idProdukt = Integer.parseInt(body.get("idProdukt"));
        int ilosc = Integer.parseInt(body.get("ilosc"));
        return szczegolyZamowieniaRepo.save(new szczegolyZamowienia(szczegolyZamowieniaId, idZamowienie, idProdukt, ilosc));
    }
}
