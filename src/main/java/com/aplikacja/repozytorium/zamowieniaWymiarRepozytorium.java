package com.aplikacja.repozytorium;

import java.util.List;
import com.aplikacja.model.zamowieniaWymiar;
import org.springframework.data. repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface zamowieniaWymiarRepozytorium extends CrudRepository<zamowieniaWymiar, Integer>{
  
    List<zamowieniaWymiar> findByIdKlient(int idKlient);
}
