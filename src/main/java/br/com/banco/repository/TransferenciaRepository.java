package br.com.banco.repository;

import br.com.banco.model.Transferencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public interface TransferenciaRepository extends JpaRepository<Transferencia, Integer> {

    @Transactional(readOnly = true)
    @Query("SELECT t FROM Transferencia t WHERE t.nome_operador_transacao LIKE %:operador% AND t.data_transferencia BETWEEN :inicio AND :fim")
    List<Transferencia> filtrarTransferencias(
            @Param("operador") String nomeOperador,
            @Param("inicio") Date dataInicio,
            @Param("fim") Date dataFim);

}
