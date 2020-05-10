package algaworks.primeirojava.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import org.hibernate.annotations.ManyToAny;

@Entity
public class OrdemServico {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Cliente cliente;

    private String descricao;
    private BigDecimal preco;

    @JsonProperty(access = Access.READ_ONLY)
    @Enumerated(EnumType.STRING)
    private StatusOrdemServico status;

    @JsonProperty(access = Access.READ_ONLY)
    private LocalDateTime dataAbertura;

    @JsonProperty(access = Access.READ_ONLY)
    private LocalDateTime dataFinalizada;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return this.preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public StatusOrdemServico getStatus() {
        return this.status;
    }

    public void setStatus(StatusOrdemServico status) {
        this.status = status;
    }

    public LocalDateTime getDataAbertura() {
        return this.dataAbertura;
    }

    public void setDataAbertura(LocalDateTime dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public LocalDateTime getDataFinalizada() {
        return this.dataFinalizada;
    }

    public void setDataFinalizada(LocalDateTime dataFinalizada) {
        this.dataFinalizada = dataFinalizada;
    }

}