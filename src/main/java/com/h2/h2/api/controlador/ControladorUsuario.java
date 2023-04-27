package com.h2.h2.api.controlador;

import com.h2.h2.api.modelo.Usuario;
import com.h2.h2.api.servicio.servicioUsuario;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class ControladorUsuario {

    private final servicioUsuario servicioUsuario;
    @PostMapping
    public ResponseEntity guardarUsuario(@RequestBody Usuario usuario){
        return new ResponseEntity(servicioUsuario.guardarUsuario(usuario), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity obtenerUsuarios(){
        return new ResponseEntity(servicioUsuario.obtenerUsuarios(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminarUsuario(@PathVariable("id") Long id){
        boolean respuesta = servicioUsuario.eliminarUsuario(id);
        if (respuesta==true){
            return new ResponseEntity(HttpStatus.OK);
        }else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping("/{data}")
    public ResponseEntity filtrarUsuario(@PathVariable("data") String data) {
        return new ResponseEntity(servicioUsuario.filtroUsuarios(data), HttpStatus.OK);
    }
}
