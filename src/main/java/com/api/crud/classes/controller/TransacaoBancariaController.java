package com.api.crud.classes.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



import com.api.crud.classes.TransacaoBancaria;
import com.api.crud.classes.service.TransacaoBancariaService;
import java.util.List;
public class TransacaoBancariaController {

    @Autowired
    TransacaoBancariaService transacaoService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody TransacaoBancaria transacao){
        if( transacao.getContaOrigem().temSaldo(transacao.getValor()) ) {
            return ResponseEntity.ok(transacaoService.create(transacao));
        }
        return ResponseEntity.badRequest().body("Saldo insuficiente");
    }
    @GetMapping
    public ResponseEntity<List<TransacaoBancaria>> getAll(){
        return ResponseEntity.ok(transacaoService.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<TransacaoBancaria> getByid(@PathVariable Long id){
        return ResponseEntity.ok(transacaoService.getById(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<TransacaoBancaria> update(@PathVariable Long id, @RequestBody TransacaoBancaria transacao){
        return ResponseEntity.ok(transacaoService.update(id, transacao));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        transacaoService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
