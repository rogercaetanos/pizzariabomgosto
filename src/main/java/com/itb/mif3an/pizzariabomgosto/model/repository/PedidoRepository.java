package com.itb.mif3an.pizzariabomgosto.model.repository;

import com.itb.mif3an.pizzariabomgosto.model.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    @Query(value = "SELECT * FROM Pedido p WHERE p.cod_status='1'", nativeQuery = true)
    public List<Pedido> findByAllActive();


    @Query(value = "SELECT * FROM Pedido p WHERE p.id=?1 AND p.cod_status='1'", nativeQuery = true)
    public List<Pedido> findByIdActive(Long id);
}
