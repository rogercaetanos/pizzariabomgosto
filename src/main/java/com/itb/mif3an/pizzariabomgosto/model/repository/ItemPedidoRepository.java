package com.itb.mif3an.pizzariabomgosto.model.repository;

import com.itb.mif3an.pizzariabomgosto.model.entity.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {

    @Query(value = "SELECT * FROM ItemPedido i WHERE i.cod_status='1'", nativeQuery = true)
    public List<ItemPedido> findByAllActive();


    @Query(value = "SELECT * FROM ItemPedido i WHERE i.id=?1 AND i.cod_status='1'", nativeQuery = true)
    public List<ItemPedido> findByIdActive(Long id);
}
