package algaworks.primeirojava.models;

import javax.validation.constraints.NotBlank;

public class ComentarioInput {

    @NotBlank
    private String descricao;

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}