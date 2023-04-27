package com.h2.h2.api.repositorio;

import com.h2.h2.api.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RepositorioUsuario extends JpaRepository<Usuario,Long> {
    @Query("SELECT u FROM Usuario u WHERE u.name LIKE %:data% OR u.email LIKE %:data%")
    List<Usuario> findAll(String data);
}

