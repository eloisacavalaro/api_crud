package com.api.crud.classes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.crud.classes.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {


}
