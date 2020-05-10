package algaworks.primeirojava.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.groups.ConvertGroup;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;

import org.hibernate.annotations.ManyToAny;

import algaworks.primeirojava.domain.ValidationGrups;
import javassist.CodeConverter.DefaultArrayAccessReplacementMethodNames;

@Entity
public class OrdemServico {

    @NotNull
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Valid
    @ConvertGroup (from = Default.class, to = ValidationGrups.ClienteId.class)
    @NotNull
    @ManyToOne
    private Cliente cliente;

    @NotBlank
    private String descricao;

    @NotNull
    private BigDecimal preco;

    @JsonProperty(access = Access.READ_ONLY)
    @Enumerated(EnumType.STRING)
    private StatusOrdemServico status;

    @JsonProperty(access = Access.READ_ONLY)
    private OffsetDateTime dataAbertura;

    @JsonProperty(access = Access.READ_ONLY)
    private OffsetDateTime dataFinalizada;

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

    public OffsetDateTime getDataAbertura() {
        return this.dataAbertura;
    }

    public void setDataAbertura(OffsetDateTime dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public OffsetDateTime getDataFinalizada() {
        return this.dataFinalizada;
    }

    public void setDataFinalizada(OffsetDateTime dataFinalizada) {
        this.dataFinalizada = dataFinalizada;
    }

}