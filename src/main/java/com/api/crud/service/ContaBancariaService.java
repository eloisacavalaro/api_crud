package com.api.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.crud.classes.ContaBancaria;
import com.api.crud.classes.TransacaoBancaria;
import com.api.crud.repository.ContaBancariaRepository;

@Service
public class ContaBancariaService {

    @Autowired
    ContaBancariaRepository contaBancariaRepository;

    ContaBancariaService(ContaBancariaRepository contaBancariaRepository) {
        this.contaBancariaRepository = contaBancariaRepository;
    }

    public List<ContaBancaria> getAll() {
        return contaBancariaRepository.findAll();
    }

    public ContaBancaria getById(Long id) {
        return contaBancariaRepository.findById(id).orElse(null);
    }

    public ContaBancaria create(ContaBancaria contaBancaria) {
        return contaBancariaRepository.save(contaBancaria);
    }

    public ContaBancaria update(ContaBancaria contaExistente, ContaBancaria contaNova) {

        contaExistente.setSaldo(contaNova.getSaldo());

        return contaBancariaRepository.save(contaExistente);
    }

    public ContaBancaria delete(Long id) {
        ContaBancaria contaBancaria = getById(id);
        contaBancariaRepository.delete(contaBancaria);
        return contaBancaria;
    }

    public boolean temSaldo(TransacaoBancaria transacao) {
        // Comprarar o saldo da conta origem com o valor da transacao
        ContaBancaria conta = getById(transacao.getContaOrigem().getNumeroConta());

        boolean temSaldo = (
            conta.getSaldo() 
            >= 
            transacao.getValor()
        );
        return temSaldo;
    }

}