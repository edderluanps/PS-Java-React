package br.com.banco.repository;

import br.com.banco.model.Movimentacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimentacaoRepository extends JpaRepository<Long, Movimentacao> {
}
