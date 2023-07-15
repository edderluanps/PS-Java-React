package br.com.banco.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "conta")
public class Conta implements Serializable {

    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_conta;

    private String nome_responsavel;

    @JsonIgnore
    @OneToMany(mappedBy = "conta_id", cascade = CascadeType.ALL)
    private List<Transferencia> transferencias = new ArrayList<>();


    public Conta(){
    }

    public Conta(int id_conta, String nome_responsavel) {
        this.id_conta = id_conta;
        this.nome_responsavel = nome_responsavel;
    }

    public int getId_conta() {
        return id_conta;
    }

    public void setId_conta(int id_conta) {
        this.id_conta = id_conta;
    }

    public String getNome_responsavel() {
        return nome_responsavel;
    }

    public void setNome_responsavel(String nome_responsavel) {
        this.nome_responsavel = nome_responsavel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Conta)) return false;
        Conta conta = (Conta) o;
        return Objects.equals(getId_conta(), conta.getId_conta());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId_conta());
    }
}
