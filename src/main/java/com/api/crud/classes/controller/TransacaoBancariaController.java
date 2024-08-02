package com.api.crud.classes.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.crud.classes.TransacaoBancaria;
import com.api.crud.classes.service.TransacaoBancariaService;

@RestController
@RequestMapping("transacoes bancaria")
public class TransacaoBancariaController {

    @Autowired
    private TransacaoBancariaService transacaoBancariaService;

    @PostMapping("/transferir")
    public ResponseEntity<TransacaoBancaria> transferir(@RequestParam Long idContaDeOrigem, @RequestParam Long idContaDestino, @RequestParam BigDecimal valor){
        TransacaoBancaria transacaoBancaria = transacaoBancariaService.transferir(idContaDeOrigem, idContaDestino, valor);

        if(transacaoBancaria == null){
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok(transacaoBancaria);
    }

    @GetMapping
    public List<TransacaoBancaria> getTransacoesBancarias(){
        return transacaoBancariaService.getTransacaoBancaria();
    }

}
