package com.h2.h2.api.servicio;

import com.h2.h2.api.modelo.Usuario;
import com.h2.h2.api.repositorio.RepositorioUsuario;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ServicioUsuarioImpl implements servicioUsuario{

    private final RepositorioUsuario repositorioUsuario;

    @Override
    public Usuario guardarUsuario(Usuario usuario) { return repositorioUsuario.save(usuario); }

    @Override
    public List<Usuario>obtenerUsuarios() {
        return repositorioUsuario.findAll();
    }

    @Override
    public boolean eliminarUsuario(Long id) {
        try{
            repositorioUsuario.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public List<Usuario> filtroUsuarios(String data){
        if (data!=null){
            return repositorioUsuario.findAll(data);
        } else {
            return repositorioUsuario.findAll();
        }
    }
}