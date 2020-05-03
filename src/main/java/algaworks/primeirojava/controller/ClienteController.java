package algaworks.primeirojava.controller;

import algaworks.primeirojava.dto.cliente.ClienteDTO;
import algaworks.primeirojava.dto.cliente.CreateClienteDTO;
import algaworks.primeirojava.service.ClienteService;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import algaworks.primeirojava.domain.repository.ClienteRepository;
import algaworks.primeirojava.models.Cliente;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteService service;

    @GetMapping
    public List<Cliente> listar() {
        return clienteRepository.findAll();
    }

    @GetMapping("/{clienteId}")
    public ResponseEntity<ClienteDTO> buscar(@PathVariable Long clienteId) {
        return ResponseEntity.of(service.buscaPorId(clienteId));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClienteDTO adicionar(@Valid @RequestBody CreateClienteDTO cliente) {
        return service.create(cliente);
    }

    @PutMapping("/{clienteId}")
    public ResponseEntity<ClienteDTO> atualizar(@Valid @PathVariable Long clienteId, @Valid @RequestBody CreateClienteDTO cliente) {
        return ResponseEntity.of(service.update(clienteId, cliente));
    }

    @DeleteMapping("/{clienteId}")
    public ResponseEntity<Void> remover(@PathVariable Long clienteId) {
        if (!service.delete(clienteId)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}