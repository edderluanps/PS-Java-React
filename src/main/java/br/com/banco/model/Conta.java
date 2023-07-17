package br.com.banco.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "conta")
@Data
public class Conta implements Serializable {

    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id_conta;

    private String nome_responsavel;

    @JsonIgnore
    @OneToMany(mappedBy = "conta_id", cascade = CascadeType.ALL)
    private List<Transferencia> transferencias = new ArrayList<>();


}
