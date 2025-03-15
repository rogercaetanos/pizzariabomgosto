package com.itb.mif3an.pizzariabomgosto.model.repository;

import com.itb.mif3an.pizzariabomgosto.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query(value = "SELECT * FROM Usuario u WHERE u.cod_status='1'", nativeQuery = true)
    public List<Usuario> findByAllActive();

    @Query(value = "SELECT * FROM Usuario u WHERE u.id=?1 AND u.cod_status='1'", nativeQuery = true)
    public List<Usuario> findByIdActive(Long id);
}
