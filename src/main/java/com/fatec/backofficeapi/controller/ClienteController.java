package com.fatec.backofficeapi.controller;

import com.fatec.backofficeapi.model.Cliente;
import com.fatec.backofficeapi.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "", produces = {"application/json"})
@Tag(name = "backoffice")
@CrossOrigin(origins = "*")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @Operation(summary = "Adiciona um cliente", method = "POST")
    @PostMapping("/cliente")
    public Cliente createCliente(@RequestBody Cliente cliente) throws Exception {
        if (cliente.getCpf() <= 0) {
            throw new Exception("CPF inválido");
        }
        return clienteService.saveCliente(cliente);
    }

    @Operation(summary = "Retorna uma lista com todos os clientes", method = "GET")
    @GetMapping("/clientes")
    public List<Cliente> getClienteList() {
        return clienteService.findAll();
    }

    @Operation(summary = "Retorna um cliente específico", method = "GET")
    @GetMapping("/cliente/{cpf}")
    public ResponseEntity<Cliente> getUsuarioById(@PathVariable("cpf") Long cpf) throws Exception {
        return ResponseEntity.ok(clienteService.getById(cpf).orElseThrow(() -> new Exception("Cliente não encontrado")));
    }

    @Operation(summary = "Atualiza os dados de um cliente", method = "PUT")
    @PutMapping("/cliente")
    public Cliente updateCliente(@RequestBody Cliente cliente) throws Exception {
        if (cliente.getCpf() <= 0) {
            throw new Exception("CPF inválido");
        }
        return clienteService.updateCliente(cliente);
    }


    @Operation(summary = "Deleta um cliente específico", method = "DELETE")
    @DeleteMapping("/cliente/{cpf}")
    public void deleteById(@PathVariable("cpf") Long cpf) {
        try {
            clienteService.deleteCliente(cpf);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Objects.requireNonNull(HttpStatus.NOT_FOUND);
        }
    }
}
