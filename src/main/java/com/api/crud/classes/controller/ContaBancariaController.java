package com.api.crud.classes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.crud.classes.ContaBancaria;
import com.api.crud.classes.service.ContaBancariaService;

@RestController
@RequestMapping("contas")
public class ContaBancariaController {

    @Autowired
    private ContaBancariaService contaBancariaService;

    @GetMapping
    public List<ContaBancaria> getAll(){
        return contaBancariaService.getAll();
    }

    @PostMapping
    public ContaBancaria create(@RequestBody ContaBancaria contaBancaria) {
        return contaBancariaService.create(contaBancaria);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContaBancaria> getById(@PathVariable Long id){
        ContaBancaria conta = contaBancariaService.getById(id);

        if(conta == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(conta);
    }

    @PostMapping("/{id}")
    public ResponseEntity<ContaBancaria> update (@PathVariable Long id, @RequestBody ContaBancaria contaAtualizada){
        ContaBancaria conta = contaBancariaService.update(id, contaAtualizada);

        if(conta == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(conta);
    }

    @GetMapping("/numeroConta/{numeroConta}")
    public ResponseEntity<ContaBancaria> getByNumeroConta(@PathVariable String numeroConta) {
        ContaBancaria conta = contaBancariaService.getByNumeroConta(numeroConta);
        if (conta == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(conta);
    }

    public ResponseEntity<Void> delete(@PathVariable Long id){
        contaBancariaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
