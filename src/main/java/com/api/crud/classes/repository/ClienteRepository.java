package com.api.crud.classes.repository;

import com.api.crud.classes.Cliente;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    List<Cliente> findByAtivoTrue();
}
