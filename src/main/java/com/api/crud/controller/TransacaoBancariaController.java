package com.api.crud.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.crud.classes.TransacaoBancaria;
import com.api.crud.service.ContaBancariaService;
import com.api.crud.service.TransacaoBancariaService;

@RestController
@RequestMapping("transacoes")
public class TransacaoBancariaController {

    @Autowired
    private TransacaoBancariaService transacaoService;

    @Autowired
    private ContaBancariaService contaBancariaService;

    @GetMapping
    public ResponseEntity<List<TransacaoBancaria>> getAll() {
        return ResponseEntity.ok(transacaoService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransacaoBancaria> getById(@PathVariable Long id) {
        return ResponseEntity.ok(transacaoService.getById(id));
    }

    @GetMapping("/extrato/{id}")
    public ResponseEntity<List<TransacaoBancaria>> getExtrato (@PathVariable Long idConta) {
        List<TransacaoBancaria> extrato = transacaoService.getExtrato(idConta);
        
        if (extrato.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(extrato);
    }

    @PostMapping
    public ResponseEntity<TransacaoBancaria> create(@RequestBody TransacaoBancaria transacao) {
        // Verificar se alguma das contas da transação são nulas
        if(contaBancariaService.temSaldo(transacao)){
            return ResponseEntity.ok(transacaoService.create(transacao));
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<TransacaoBancaria> update(@PathVariable Long id, @RequestBody TransacaoBancaria transacao) {
        return ResponseEntity.ok(transacaoService.update(id, transacao));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        transacaoService.delete(id);
        return ResponseEntity.noContent().build();
    }
    

}
