
package com.portfolio.ap.Repository;

import com.portfolio.ap.entity.hys;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Rhys extends JpaRepository<hys, Integer>{
   Optional<hys> findByNombre (String nombre);
   public boolean existsByNombre(String nombre);
}
