package com.api.crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.crud.classes.ContaBancaria;
import com.api.crud.classes.TransacaoBancaria;

public interface TransacaoBancariaRepository extends JpaRepository<TransacaoBancaria, Long>{

List<TransacaoBancaria> findByContaOrigemOrContaDestinoOrderByDataDesc(
        ContaBancaria contaOrigem, 
        ContaBancaria contaDestino
    );

}
