package algaworks.primeirojava.dto.cliente;

import algaworks.primeirojava.models.Cliente;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CreateClienteDTO {

  private Long id;

  @NotBlank
  @Size(max = 60)
  private String nome;

  @NotBlank
  @Email
  @Size(max = 255)
  private String email;

  @NotBlank
  @Size(max = 20)
  private String telefone;

  public Cliente createCliente() {
    return new Cliente(this.nome, this.email, this.telefone);
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getTelefone() {
    return telefone;
  }

  public void setTelefone(String telefone) {
    this.telefone = telefone;
  }
}
