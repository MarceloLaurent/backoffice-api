package com.fatec.backofficeapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.backofficeapi.model.CarrinhoDTO;
import com.fatec.backofficeapi.model.Cliente;
import com.fatec.backofficeapi.repository.ClienteRepository;

@Service
public class ClienteService {

    ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente saveCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> getById(Long cpf) {
        return clienteRepository.findById(cpf);
    }

    public Cliente updateCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public void deleteCliente(Long cpf) {
        clienteRepository.deleteById(cpf);
    }
    
    public Optional<CarrinhoDTO> getCarrinhoById(Long cpf) {
    	Optional<Cliente> cliente = clienteRepository.findById(cpf);
    	
    	if (cliente.isPresent()) {
			return Optional.of(cliente.get().getCarrinhoDTO());
		}
    	
    	return Optional.empty();	
    }
}
