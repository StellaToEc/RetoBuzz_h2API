package com.h2.h2.api.servicio;

import com.h2.h2.api.modelo.Usuario;
import java.util.List;

public interface servicioUsuario {
    //post
    Usuario guardarUsuario(Usuario usuario);
    //get todos
    List<Usuario> obtenerUsuarios();
    //delete
    boolean eliminarUsuario(Long id);
    //get filtro
    List<Usuario> filtroUsuarios(String data);
}
