package com.api.crud.repository;

import com.api.crud.classes.Cliente;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    // Método para buscar somente os clientes ativos (GetAllAtivos)
    List<Cliente> findByClienteAtivoTrue();

    @Query("SELECT new com.api.senai.dto.ClienteDTO(c.id, c.nome) FROM Cliente c")
    List<Cliente> getClientesDTO();

}
