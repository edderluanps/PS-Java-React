package br.com.banco.repository;

import br.com.banco.model.Banco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BancoRepository extends JpaRepository<Long, Banco> {
}
