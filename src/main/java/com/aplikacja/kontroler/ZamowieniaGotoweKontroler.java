package com.aplikacja.kontroler;

import com.aplikacja.model.zamowieniaGotowe;
import com.aplikacja.repozytorium.zamowieniaGotoweRepozytorium;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("zamowieniaGotowe")
public class ZamowieniaGotoweKontroler {

    @Autowired
    zamowieniaGotoweRepozytorium zamowieniaGotoweRepo;

    @PostMapping("/dodajTestowe")
    public String dodajDaneTestoweZamowieniaGotowe (){

        zamowieniaGotoweRepo.saveAll (Arrays. asList(
                new zamowieniaGotowe(1, LocalDate.of(2023, 4, 12), LocalDate.of(2023, 4, 20), 600.0),
                new zamowieniaGotowe (2, LocalDate.of(2023, 5, 2), LocalDate.of(2023, 5, 12), 455.0),
                new zamowieniaGotowe (3, LocalDate.of(2023, 5, 14), LocalDate.of(2023, 5, 22), 999.99)));

        return "Testowe rekordy dodane!";
    }
    @GetMapping("/pokazWszystkie")
    public List<zamowieniaGotowe> pokarzWszystkieZamowieniaGotowe(){
        List<zamowieniaGotowe> listazamowieniaGotowe = new ArrayList<zamowieniaGotowe>();
        for(zamowieniaGotowe projekt : zamowieniaGotoweRepo.findAll()){
            listazamowieniaGotowe.add(projekt) ;
        }
        return listazamowieniaGotowe;
    }
    @GetMapping("/wyszukajPoId/{id}")
    public String szukajPoIdZamowieniaGotowe(@PathVariable("id") Integer id) {
        String result = zamowieniaGotoweRepo.findById (id) .toString();
        return result;
    }
    @GetMapping("/szukajPoNazwie/{idKlienta}")
    public String fetchDataByNazwaZamowieniaGotowe (@PathVariable("idKlienta") int idKlienta) {
        for (zamowieniaGotowe projekt: zamowieniaGotoweRepo.findByIdKlient (idKlienta) ) {
            return projekt.toString ();
        }
        return null;
    }
    @DeleteMapping("/{id}")
    public String usunPoIdZamowieniaGotowe(@PathVariable("id") Integer id) {
        zamowieniaGotoweRepo.deleteById (id);
        return "Rekord usunięty";
    }
    @PostMapping("/utworz")
    public zamowieniaGotowe utworzZamowieniaGotowe (@RequestBody Map<String, Object> body) {
        int idKlient = Integer.parseInt(body.get("idKlient").toString());
        LocalDate dataZakupu = LocalDate.parse(body.get("dataZakupu").toString());
        LocalDate dataRealizacji = LocalDate.parse(body.get("dataRealizacji").toString());
        Double cena = Double.parseDouble(body.get("cena").toString());
        return zamowieniaGotoweRepo.save(new zamowieniaGotowe (idKlient, dataZakupu, dataRealizacji, cena));
    }
    @PutMapping ("/zmien")
    public zamowieniaGotowe zmienZamowieniaGotowe (@RequestBody Map<String, Object> body) {
        int zamowieniaGotoweId = Integer.parseInt(body.get("zamowieniaGotoweId").toString());
        int idKlient = Integer.parseInt(body.get("idKlient").toString());
        LocalDate dataZakupu = LocalDate.parse(body.get("dataZakupu").toString());
        LocalDate dataRealizacji = LocalDate.parse(body.get("dataRealizacji").toString());
        Double cena = Double.parseDouble(body.get("cena").toString());
        return zamowieniaGotoweRepo.save(new zamowieniaGotowe(zamowieniaGotoweId, idKlient, dataZakupu, dataRealizacji, cena));
    }
}
