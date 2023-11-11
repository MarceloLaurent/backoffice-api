package com.fatec.backofficeapi.repository;

import com.fatec.backofficeapi.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
