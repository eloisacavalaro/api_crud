package com.api.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.crud.classes.ContaBancaria;
import com.api.crud.classes.TransacaoBancaria;
import com.api.crud.repository.TransacaoBancariaRepository;

@Service
public class TransacaoBancariaService {

    @Autowired
    TransacaoBancariaRepository transacaoRepository;

    @Autowired
    ContaBancariaService contaBancariaService;

    public List<TransacaoBancaria> getAll() {
        return transacaoRepository.findAll();
    }

    public TransacaoBancaria getById(Long id) {
        return transacaoRepository.findById(id).orElse(null);
    }

    public List<TransacaoBancaria> getExtrato(Long id) {
        // Tratar possível erro de retorno null
        ContaBancaria conta = contaBancariaService.getById(id);

        return transacaoRepository.findByContaOrigemOrContaDestinoOrderByDataDesc(conta, conta);
    }

    public TransacaoBancaria create(TransacaoBancaria novaTransacao) {
        // Tratar a possibilidade de valores nulos nos atributos da transacao
        TransacaoBancaria transacao = new TransacaoBancaria();

        ContaBancaria contaOrigem = contaBancariaService.getById(novaTransacao.getContaOrigem().getNumeroConta());
        ContaBancaria contaDestino = contaBancariaService.getById(novaTransacao.getContaDestino().getNumeroConta());

        contaOrigem.sacar(novaTransacao.getValor());
        contaDestino.depositar(novaTransacao.getValor());

        contaBancariaService.create(contaDestino);
        contaBancariaService.create(contaOrigem);
        
        transacao.setValor(novaTransacao.getValor());
        transacao.setContaDestino(contaBancariaService.getById(novaTransacao.getContaDestino().getNumeroConta()));
        transacao.setContaOrigem(contaBancariaService.getById(novaTransacao.getContaOrigem().getNumeroConta()));
        transacao.setTipoTransacao(novaTransacao.getTipoTransacao());

        return transacaoRepository.save(transacao);
    }

    public TransacaoBancaria update(Long id, TransacaoBancaria novaTransacao) {
        TransacaoBancaria transacao = transacaoRepository.findById(id).orElse(null);
        if (novaTransacao == null) {
            return null;
        }
        // Incluir os atributos que deseja atualizar
        return transacaoRepository.save(transacao);
    }

    public void delete(Long id) {
        transacaoRepository.deleteById(id);
    }

}
