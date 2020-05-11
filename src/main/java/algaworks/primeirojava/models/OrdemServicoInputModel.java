package algaworks.primeirojava.models;

import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class OrdemServicoInputModel {

    @NotBlank
    private String descricao;
    
    @NotNull
    private BigDecimal preco;

    @Valid
    @NotNull
    private ClienteIdInput cliente;

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

    public ClienteIdInput getCliente() {
        return this.cliente;
    }

    public void setCliente(ClienteIdInput cliente) {
        this.cliente = cliente;
    }




}