package com.api.crud;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("clientes")
public class ClienteController {

    // Buscar todos os clientes - getAll
    @GetMapping
    public String getAll() {
        if (Cliente.clientes.isEmpty()) {
            return "Não há clientes cadastrados.";
        } else {
            String resposta = Cliente.clientes.toString();
            return resposta;
        }
    }

    // Criar um cliente - create
    @PostMapping
    public String create(@RequestBody Cliente cliente) {
        Cliente.clientes.add(cliente);
        return "Cliente cadastrado com sucesso!";
    }

    // Buscar um cliente por id - getById
    @GetMapping("/{id}")
    public String getById(@PathVariable UUID id) {
        for (Cliente cliente : Cliente.clientes) {
            if (cliente.getId().equals(id)) {
                return cliente.toString();
            }
        }
        return "Cliente não encontrado.";
    }

    // Atualizar um cliente - update
    @PutMapping("/{id}")
    public String update(@PathVariable UUID id, @RequestBody Cliente clienteAtualizado) {
        for (int i = 0; i < Cliente.clientes.size(); i++) {
            Cliente cliente = Cliente.clientes.get(i);
            if (cliente.getId().equals(id)) {
                cliente.setNome(clienteAtualizado.getNome());
                cliente.setCpf(clienteAtualizado.getCpf());
                cliente.setEndereco(clienteAtualizado.getEndereco());
                cliente.setTelefone(clienteAtualizado.getTelefone());
                cliente.setEmail(clienteAtualizado.getEmail());
                cliente.setDataNascimento(clienteAtualizado.getDataNascimento());
                return "Cliente atualizado com sucesso!";
            }
        }
        return "Cliente não encontrado.";
    }

    // Deletar um cliente - delete
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCliente(@PathVariable UUID id) {
        for (int i = 0; i < Cliente.clientes.size(); i++) {
            Cliente cliente = Cliente.clientes.get(i);
            if (cliente.getId().equals(id)) {
                Cliente.clientes.remove(i);
                return ResponseEntity.ok("Cliente deletado com sucesso!");
            }
        }
        return ResponseEntity.status(404).body("Cliente não encontrado.");
    }

}
