package com.aplikacja.repozytorium;

import java.util.List;
import com.aplikacja.model.szczegolyZamowienia;
import org.springframework.data. repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface szczegolyZamowieniaRepozytorium extends CrudRepository<szczegolyZamowienia, Integer>{
    
   List<szczegolyZamowienia> findByIdZamowienie(int idZamowienia);
}
