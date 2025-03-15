package com.itb.mif3an.pizzariabomgosto.model.repository;

import com.itb.mif3an.pizzariabomgosto.model.entity.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TelefoneRepository extends JpaRepository<Telefone, Long> {

    @Query(value = "SELECT * FROM Telefone t WHERE t.cod_status='1'", nativeQuery = true)
    public List<Telefone> findByAllActive();


    @Query(value = "SELECT * FROM Telefone t WHERE t.id=?1 AND t.cod_status='1'", nativeQuery = true)
    public List<Telefone> findByIdActive(Long id);
}
