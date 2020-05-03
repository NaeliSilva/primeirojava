package algaworks.primeirojava.service;

import algaworks.primeirojava.domain.repository.ClienteRepository;
import algaworks.primeirojava.dto.cliente.ClienteDTO;
import algaworks.primeirojava.dto.cliente.CreateClienteDTO;
import algaworks.primeirojava.models.Cliente;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ClienteService {

  private ClienteRepository repository;

  @Autowired
  public ClienteService(ClienteRepository repository) {
    this.repository = repository;
  }

  public ClienteDTO create(CreateClienteDTO createClienteDTO) {
    Cliente cliente = createClienteDTO.createCliente();
    repository.save(cliente);
    return new ClienteDTO(cliente);
  }

  public Optional<ClienteDTO> update(Long id, CreateClienteDTO createClienteDTO) {
    if (!repository.existsById(id)) {
      return Optional.empty();
    }
    Cliente cliente = createClienteDTO.createCliente();
    cliente.setId(id);
    repository.save(cliente);
    return Optional.of(new ClienteDTO(cliente));
  }

  public Optional<ClienteDTO> buscaPorId(Long clienteId) {
    Optional<Cliente> cliente = repository.findById(clienteId);
    if (cliente.isPresent()) {
      return Optional.of(new ClienteDTO(cliente.get()));
    }
    return Optional.empty();
  }

  public boolean delete(Long clienteId) {
    if (!repository.existsById(clienteId)) {
      return false;
    }
    repository.deleteById(clienteId);
    return true;
  }
}
