package com.api.crud.classes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.crud.classes.Cliente;
import com.api.crud.classes.Endereco;
import com.api.crud.classes.repository.ClienteRepository;
import com.api.crud.classes.repository.EnderecoRepository;

import jakarta.transaction.Transactional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Transactional
    public Cliente create(Cliente cliente) {
        Endereco endereco = cliente.getEndereco();
        if (endereco != null) {
            endereco = enderecoRepository.save(endereco);
            cliente.setEndereco(endereco);
        }
        return clienteRepository.save(cliente);
    }

    public List<Cliente> getAll() {
        return clienteRepository.findAll();                   
    }

    public Cliente getById(Long id){
        return clienteRepository.findById(id)
                                .orElse(null);
    }

    @Transactional
    public Cliente update(Long id, Cliente cliente) {
        Cliente clienteExistente = getById(id);

        if (clienteExistente == null){
            return null;
        }

        Endereco endereco = cliente.getEndereco();
        if (endereco != null) {
            endereco = enderecoRepository.save(endereco);
            cliente.setEndereco(endereco);
        }

        clienteExistente.setNome(cliente.getNome());
        clienteExistente.setCpf(cliente.getCpf());
        clienteExistente.setEndereco(cliente.getEndereco());
        clienteExistente.setTelefone(cliente.getTelefone());
        clienteExistente.setEmail(cliente.getEmail());
        clienteExistente.setDataNascimento(cliente.getDataNascimento());

        return clienteRepository.save(clienteExistente);
    }

    public void delete(Long id){
        clienteRepository.deleteById(id);
    }
}



