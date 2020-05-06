package algaworks.primeirojava.dto.cliente;

import algaworks.primeirojava.models.Cliente;

public class ClienteDTO {

  private Long id;

  private String nome;

  private String email;

  private String telefone;

  public ClienteDTO() {
  }

  public ClienteDTO(Cliente cliente) {
    this.id = cliente.getId();
    this.nome = cliente.getNome();
    this.telefone = cliente.getTelefone();
    this.email = cliente.getEmail();
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
