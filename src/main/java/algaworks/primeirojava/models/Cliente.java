package algaworks.primeirojava.models;


import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Cliente {

    private Long id;
    private String nome;
    private String email;
    private String telefone;
}