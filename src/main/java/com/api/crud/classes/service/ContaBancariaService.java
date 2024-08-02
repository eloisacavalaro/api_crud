package com.api.crud.classes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.crud.classes.ContaBancaria;
import com.api.crud.classes.repository.ContaBancariaRepository;

@Service
public class ContaBancariaService {

    @Autowired
    private ContaBancariaRepository contaBancariaRepository;

    public List<ContaBancaria> getAll(){
        return contaBancariaRepository.findAll();
    }

    public ContaBancaria getById(Long id){
        return contaBancariaRepository.findById(id)
                                      .orElse(null);
    }

    public ContaBancaria create(ContaBancaria contaBancaria){
        return contaBancariaRepository.save(contaBancaria);
    }
    
    public ContaBancaria getByNumeroConta(String numeroConta) {
        return contaBancariaRepository.findByNumeroConta(numeroConta);
    }

    public ContaBancaria update(Long id, ContaBancaria contaBancaria){
        ContaBancaria contaExistente = getById(id);

        if(contaExistente == null){
            return null;
        }

        contaExistente.setCliente(contaBancaria.getCliente());
        contaExistente.setNumeroConta(contaBancaria.getNumeroConta());
        contaExistente.setSaldo(contaBancaria.getSaldo());

        return contaBancariaRepository.save(contaExistente);
    }
    public void delete (Long id){
        contaBancariaRepository.deleteById(id);
    }
}
