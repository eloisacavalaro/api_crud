package com.api.crud.classes.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.crud.classes.ContaBancaria;
import com.api.crud.classes.TransacaoBancaria;
import com.api.crud.classes.repository.TransacaoBancariaRepository;

@Service
public class TransacaoBancariaService {

    @Autowired
    private TransacaoBancariaRepository transacaoBancariaRepository;

    @Autowired
    private ContaBancariaService contaBancariaService;

    public TransacaoBancaria transferir(Long idContaDeOrigem, Long idContaDestino,  BigDecimal valor){
        ContaBancaria contaDeOrigem = contaBancariaService.getById(idContaDeOrigem);
        ContaBancaria contaDestino = contaBancariaService.getById(idContaDestino);

        if(contaDeOrigem == null || contaDestino == null || contaDeOrigem.getSaldo().compareTo(valor)<0){
            return null;
        }

        contaDeOrigem.setSaldo(contaDeOrigem.getSaldo().subtract(valor));
        contaDestino.setSaldo(contaDestino.getSaldo().add(valor));

        contaBancariaService.update(idContaDeOrigem, contaDeOrigem);
        contaBancariaService.update(idContaDestino, contaDestino);

        TransacaoBancaria transacaoBancaria = new TransacaoBancaria();
        transacaoBancaria.setContaDeOrigem(contaDeOrigem);
        transacaoBancaria.setContaDestino(contaDestino);
        transacaoBancaria.setValor(valor);

        return transacaoBancariaRepository.save(transacaoBancaria);
    }

    public List<TransacaoBancaria> getTransacaoBancaria(){
        return transacaoBancariaRepository.findAll();
    }

}
