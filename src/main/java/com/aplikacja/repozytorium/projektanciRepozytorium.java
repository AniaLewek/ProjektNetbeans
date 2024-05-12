
package com.aplikacja.repozytorium;

import java.util.List;
import com.aplikacja.model.projektanci;
import org.springframework.data. repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface projektanciRepozytorium extends CrudRepository<projektanci, Integer>{
  
    List<projektanci> findByEmail(String email);
}
