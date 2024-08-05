package com.api.crud.classes.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.crud.classes.TransacaoBancaria;
import com.api.crud.classes.repository.TransacaoBancariaRepository;

@Service
public class TransacaoBancariaService {

 @Autowired
 TransacaoBancariaRepository transacaoRepository;
 
 public List<TransacaoBancaria> getAll(){
    return transacaoRepository.findAll();
 }
 public TransacaoBancaria getById(Long id){
    return transacaoRepository.findById(id).orElse(null);
 }
 public TransacaoBancaria create(TransacaoBancaria transacao){
    if( transacao.getContaOrigem().temSaldo(transacao.getValor()) ) {
   }
   return transacaoRepository.save(transacao);
 }
 public TransacaoBancaria update(Long id, TransacaoBancaria transacao){
    TransacaoBancaria transacaoAtualizar = transacaoRepository.findById(id).orElse(null);
    if (transacaoAtualizar == null) {
        return null;
        }
        return transacaoRepository.save(transacaoAtualizar);
 }
 public void delete(Long id){
    transacaoRepository.deleteById(id);
 }

}
