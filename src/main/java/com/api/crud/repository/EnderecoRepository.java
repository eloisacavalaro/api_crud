package com.api.crud.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.api.crud.classes.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}

