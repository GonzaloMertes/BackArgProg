
package com.portfolio.ap.Service;

import com.portfolio.ap.Repository.IPersonaRepository;
import com.portfolio.ap.entity.Persona;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

//llamamos al metodo service
@Service 
@Transactional
public class ImpPersonaService {
//@Autowired permite resolver la inyección de dependencias de los siguiente modos. En el constructor de la clase. En un atributo. En un método setter.
    @Autowired 
    IPersonaRepository ipersonaRepository;
//cuando se hace sobreescritura de un método en Java, se usa la anotación @Override
   
     public List<Persona> list (){
        return ipersonaRepository.findAll();
    }
    
    public Optional<Persona> getOne (int id){
        return ipersonaRepository.findById(id);
    }
    
    public Optional<Persona> getByNombre (String nombre){
        return ipersonaRepository.findByNombre(nombre);
    }
    
    public void save (Persona persona){
        ipersonaRepository.save(persona);
    }
    
    //con el void no se devuelve nada
    public void delete(int id){
        ipersonaRepository.deleteById(id);
    }
    
    public boolean existsById (int id){
        return ipersonaRepository.existsById(id);
    }
    
    public boolean existsByNombre (String nombre){
        return ipersonaRepository.existsByNombre(nombre);
    }
    
}
