package br.com.banco.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "tb_movimentacao")
public class Movimentacao implements Serializable {

    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataMovimentacao;

    private Float debitoTotal;

    private Float valorMovimentacao;

    public Movimentacao() {
    }

    public Movimentacao(Long id, String descricao, LocalDate dataMovimentacao, Float debitoTotal, Float valorMovimentacao) {
        this.id = id;
        this.descricao = descricao;
        this.dataMovimentacao = dataMovimentacao;
        this.debitoTotal = debitoTotal;
        this.valorMovimentacao = valorMovimentacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataMovimentacao() {
        return dataMovimentacao;
    }

    public void setDataMovimentacao(LocalDate dataMovimentacao) {
        this.dataMovimentacao = dataMovimentacao;
    }

    public Float getDebitoTotal() {
        return debitoTotal;
    }

    public void setDebitoTotal(Float debitoTotal) {
        this.debitoTotal = debitoTotal;
    }

    public Float getValorMovimentacao() {
        return valorMovimentacao;
    }

    public void setValorMovimentacao(Float valorMovimentacao) {
        this.valorMovimentacao = valorMovimentacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Movimentacao)) return false;
        Movimentacao that = (Movimentacao) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
