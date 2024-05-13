package com.aplikacja.kontroler;

import com.aplikacja.model.zamowieniaWymiar;
import com.aplikacja.repozytorium.zamowieniaWymiarRepozytorium;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("zamowieniaWymiar")
public class ZamowieniaWymiarKontroler {

    @Autowired
    zamowieniaWymiarRepozytorium zamowieniaWymiarRepo;


    @PostMapping("/dodajTestowe")
    public String dodajDaneTestoweZamowieniaWymiar(){

        zamowieniaWymiarRepo.saveAll (Arrays. asList(
                new zamowieniaWymiar(1, 1, LocalDate.of(2023, 4, 15), LocalDate.of(2023, 5, 12), 1000.0),
                new zamowieniaWymiar (2, 2, LocalDate.of(2023, 4, 29), LocalDate.of(2023, 5, 30), 1600.0),
                new zamowieniaWymiar (3, 3, LocalDate.of(2023, 5, 10), LocalDate.of(2023, 6, 12), 950.0)));

        return "Testowe rekordy dodane!";
    }
    @GetMapping("/pokazWszystkie")
    public List<zamowieniaWymiar> pokarzWszystkieZamowieniaWymiar(){
        List<zamowieniaWymiar> listazamowieniaWymiar = new ArrayList<zamowieniaWymiar>();
        for(zamowieniaWymiar projekt : zamowieniaWymiarRepo.findAll()){
            listazamowieniaWymiar.add(projekt) ;
        }
        return listazamowieniaWymiar;
    }
    @GetMapping("/wyszukajPoId/{id}")
    public String szukajPoIdZamowieniaWymiar(@PathVariable("id") Integer id) {
        String result = zamowieniaWymiarRepo.findById (id) .toString();
        return result;
    }
    @GetMapping("/szukajPoNazwie/{idKlienta}")
    public String fetchDataByNazwaZamowieniaWymiar (@PathVariable("idKlienta") int idKlienta) {
        for (zamowieniaWymiar projekt: zamowieniaWymiarRepo.findByIdKlient (idKlienta) ) {
            return projekt.toString ();
        }
        return null;
    }
    @DeleteMapping("/{id}")
    public String usunPoIdZamowieniaWymiar(@PathVariable("id") Integer id) {
        zamowieniaWymiarRepo.deleteById (id);
        return "Rekord usunięty";
    }
    @PostMapping("/utworz")
    public zamowieniaWymiar utworzZamowieniaWymiar (@RequestBody Map<String, Object> body) {
        int idKlient = Integer.parseInt(body.get("idKlient").toString());
        int idProjektant = Integer.parseInt(body.get("idProjektant").toString());
        LocalDate dataZakupu = LocalDate.parse(body.get("dataZakupu").toString());
        LocalDate dataRealizacji = LocalDate.parse(body.get("dataRealizacji").toString());
        Double cena = Double.parseDouble(body.get("cena").toString());
        return zamowieniaWymiarRepo.save(new zamowieniaWymiar (idKlient,idProjektant, dataZakupu, dataRealizacji, cena));
    }
    @PutMapping ("/zmien")
    public zamowieniaWymiar zmienZamowieniaWymiar (@RequestBody Map<String, Object> body) {
        int zamowieniaWymiarId = Integer.parseInt(body.get("zamowieniaWymiarId").toString());
        int idKlient = Integer.parseInt(body.get("idKlient").toString());
        int idProjektant = Integer.parseInt(body.get("idProjektant").toString());
        LocalDate dataZakupu = LocalDate.parse(body.get("dataZakupu").toString());
        LocalDate dataRealizacji = LocalDate.parse(body.get("dataRealizacji").toString());
        Double cena = Double.parseDouble(body.get("cena").toString());
        return zamowieniaWymiarRepo.save(new zamowieniaWymiar(zamowieniaWymiarId, idKlient, idProjektant, dataZakupu, dataRealizacji, cena));
    }
    
}
