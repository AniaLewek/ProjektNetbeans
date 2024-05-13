package com.aplikacja.repozytorium;

import java.util.List;
import com.aplikacja.model.zamowieniaGotowe;
import org.springframework.data. repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface zamowieniaGotoweRepozytorium extends CrudRepository<zamowieniaGotowe, Integer>{
    
    List<zamowieniaGotowe> findByIdKlient(int idKlienta);
}
