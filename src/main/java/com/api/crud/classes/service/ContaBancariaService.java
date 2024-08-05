package com.api.crud.classes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.crud.classes.ContaBancaria;
import com.api.crud.classes.repository.ContaBancariaRepository;


@Service
public class ContaBancariaService {
    @Autowired
    private ContaBancariaRepository contaRepository;

    public ContaBancaria create(ContaBancaria conta){
        return contaRepository.save(conta);

    }
    public List<ContaBancaria> getAll(){
        return contaRepository.findAll();
    }
    public ContaBancaria getByid(Long id){
        return contaRepository.findById(id).orElse(null);

    }
    public ContaBancaria atualizarConta(ContaBancaria conta, Long id){
       ContaBancaria contaAtualizar = getByid(id);
        if (contaAtualizar == null) {
            return null;
            }
            contaAtualizar.setSaldo(conta.getSaldo());
           return contaRepository.save(contaAtualizar);
    }
    public void delete(Long id){
        contaRepository.deleteById(id);
    }
    


}
