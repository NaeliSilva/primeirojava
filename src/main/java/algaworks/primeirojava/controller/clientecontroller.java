package algaworks.primeirojava.controller;


import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import algaworks.primeirojava.domain.repository.ClienteRepository;
import algaworks.primeirojava.models.Cliente;

@RestController
@RequestMapping("/clientes")
public class clientecontroller {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public List<Cliente> listar() {
        // return clienteRepository.findAll();
        return clienteRepository.findByNomeContaining("Silva");
    }

    @GetMapping("/{clienteId}")
    public ResponseEntity <Cliente> buscar(@PathVariable final Long clienteId) {
        final Optional<Cliente> cliente = clienteRepository.findById(clienteId);

        if (cliente.isPresent()) {
            return ResponseEntity.ok(cliente.get());
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public Cliente adicionar(@RequestBody Cliente cliente) {
    return clienteRepository.save(cliente);
}
}