package naeli.primeirojava.models;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.Valid;

import naeli.primeirojava.controller.NegocioException;



@Entity
public class OrdemServico {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Valid
    @ManyToOne
    private Cliente cliente;

    private String descricao;
    private BigDecimal preco;


    @Enumerated(EnumType.STRING)
    private StatusOrdemServico status;

    private OffsetDateTime dataAbertura;
    private OffsetDateTime dataFinalizada;

    @OneToMany(mappedBy = "ordemServico")
    private java.util.List<Comentario> comentarios = new ArrayList<>();


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

    public java.util.List<Comentario> getComentarios() {
        return this.comentarios;
    }

    public void setComentarios(java.util.List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        Cliente other = (Cliente) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    public boolean podeSerFinalizada() {
        return StatusOrdemServico.ABERTA.equals(getStatus());
    
    }

    public boolean naoPodeSerFinalizado() {
        return !podeSerFinalizada();
    }

	public void finalizar() {
        if (naoPodeSerFinalizado()) {
            throw new NegocioException("Ordem de serviço não pode ser finalizada, amada(o)");
        }

        setStatus(StatusOrdemServico.FINALIZADA);
        setDataFinalizada(OffsetDateTime.now());
	}

}
