package com.aplikacja.repozytorium;

import java.util.List;
import com.aplikacja.model.klienci;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface klienciRepozytorium extends CrudRepository<klienci, Integer>{
    
    List<klienci> findByEmail(String email);
}
