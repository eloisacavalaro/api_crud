package com.api.crud.classes;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "transacoes Bancaria")
public class TransacaoBancaria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private ContaBancaria contaDeOrigem;

    @ManyToOne
    private ContaBancaria contaDestino;

    @Column(nullable = false)
    private LocalDateTime dataEHora = LocalDateTime.now();

     @Column(nullable = false)
    private BigDecimal valor;

}
