package com.api.crud.classes.controller;

import com.api.crud.classes.ContaBancaria;

import com.api.crud.classes.service.ContaBancariaService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("contas")
public class ContaBancariaController {

    @Autowired
    private ContaBancariaService contaService;
    
    @PostMapping
    public ResponseEntity<ContaBancaria> criarConta(@RequestBody ContaBancaria conta){
        ContaBancaria novaConta = contaService.create(conta);
        return ResponseEntity.ok(novaConta);
    }
    @GetMapping
    public ResponseEntity<List<ContaBancaria>> listadeContas(){
        List<ContaBancaria> contas = contaService.getAll();
        return ResponseEntity.ok(contas);
        
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ContaBancaria> buscarContasPorId(@PathVariable Long id){
     ContaBancaria conta = contaService.getByid(id);
     if (conta == null) {
        return ResponseEntity.notFound().build();
         }
         return ResponseEntity.ok(conta);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ContaBancaria> atualizarConta(@PathVariable Long id, @RequestBody ContaBancaria contaAtualizada){
       ContaBancaria conta = contaService.getByid(id);
       if (conta == null) {
        return null;
        }
        conta.setSaldo(contaAtualizada.getSaldo());
        return ResponseEntity.ok(conta);

      
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarConta(@PathVariable Long id){
       ContaBancaria conta = contaService.getByid(id);
       if (conta == null) {
        return ResponseEntity.notFound().build();
        
       }
       contaService.delete(id);
       return ResponseEntity.noContent().build();
    }


}
