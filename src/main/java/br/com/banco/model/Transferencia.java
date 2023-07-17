package br.com.banco.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "transferencia")
@Data
public class Transferencia implements Serializable {

    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Timestamp data_transferencia;

    private Double valor;

    private String tipo;

    private String nome_operador_transacao;

    @ManyToOne
    @JoinColumn(name = "conta_id")
    private Conta conta_id;

}
