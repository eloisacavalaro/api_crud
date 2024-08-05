package com.api.crud.classes;

import com.api.crud.classes.tipotransacao.TipoTransacao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "transacoes")
public class TransacaoBancaria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Enumerated
    private TipoTransacao tipoTransacao;

    @Column(nullable = false)
    private double valor;

    @ManyToOne
    @JoinColumn(name = "conta_origem", referencedColumnName = "id")
    private ContaBancaria contaOrigem;

    @ManyToOne
    @JoinColumn(name = "conta_destino", referencedColumnName = "id")
    private ContaBancaria contaDestino;

}
