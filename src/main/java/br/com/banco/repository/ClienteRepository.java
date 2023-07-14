package br.com.banco.repository;

import br.com.banco.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Long, Cliente> {
}
