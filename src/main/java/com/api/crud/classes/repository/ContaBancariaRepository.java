package com.api.crud.classes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.crud.classes.ContaBancaria;

public interface ContaBancariaRepository extends JpaRepository<ContaBancaria, Long> {

    ContaBancaria findByNumeroConta(String numeroConta);

}
