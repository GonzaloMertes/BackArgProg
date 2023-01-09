package com.portfolio.ap.Controller;

import com.portfolio.ap.Dto.dtoProyectos;
import com.portfolio.ap.Security.Controller.Mensaje;
import com.portfolio.ap.Service.SProyectos;
import com.portfolio.ap.entity.Proyectos;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping ("pro")
@CrossOrigin(origins = {"http://localhost:4200","https://frontendprueba-43463.web.app"})
public class CProyectos {
@Autowired
    SProyectos sProyectos;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Proyectos>> list(){
        List<Proyectos> list =sProyectos.list();
        return new ResponseEntity(list,HttpStatus.OK);
    } 
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoProyectos dtopro){
        if (StringUtils.isBlank(dtopro.getNombre()))
            return new ResponseEntity (new Mensaje ("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if (sProyectos.existsByNombre(dtopro.getNombre()))
            return new ResponseEntity(new Mensaje ("Ese Proyecto Existe"), HttpStatus.BAD_REQUEST);
        
        Proyectos proyectos = new Proyectos (dtopro.getNombre(),dtopro.getDescripcion(),dtopro.getFecha(),dtopro.getLink());
        sProyectos.save(proyectos);
        
        return new ResponseEntity (new Mensaje ("Proyecto agregado"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoProyectos dtopro){
        //VALIDACION DE EXISTENCIA DEL ID
        if(!sProyectos.existsById(id))
            return new ResponseEntity(new Mensaje ("El ID no existe"), HttpStatus.BAD_REQUEST);
        
        //COMPRA NOMBRE DE LAS EXP
        if(sProyectos.existsByNombre(dtopro.getNombre()) && sProyectos.getByNombre(dtopro.getNombre()).get().getId()!=id)
        return new ResponseEntity (new Mensaje ("Ese proyecto existe"),HttpStatus.BAD_REQUEST);
        
        
        //NO PUEDE ESTAR VACIO
        if(StringUtils.isBlank(dtopro.getNombre()))
            return new ResponseEntity(new Mensaje ("El nombre es requerido"), HttpStatus.BAD_REQUEST);
        
        Proyectos proyectos = sProyectos.getOne(id).get();
        proyectos.setNombre(dtopro.getNombre());
        proyectos.setDescripcion((dtopro.getDescripcion()));
        proyectos.setFecha(dtopro.getFecha());
        proyectos.setLink(dtopro.getLink());
        
        
        sProyectos.save(proyectos);
        return new ResponseEntity(new Mensaje ("Proyecto actualizado"),HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyectos> getById(@PathVariable("id") int id){
        if(!sProyectos.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Proyectos proyectos = sProyectos.getOne(id).get();
        return new ResponseEntity(proyectos, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity <?> delete(@PathVariable ("id") int id){
        //VALIDACION DE EXISTENCIA DEL ID
        if(!sProyectos.existsById(id))
            return new ResponseEntity(new Mensaje ("El ID no existe"), HttpStatus.BAD_REQUEST);
        
        sProyectos.delete(id);
        
        return new ResponseEntity(new Mensaje ("Proyecto eliminado"), HttpStatus.OK);
    }
}
