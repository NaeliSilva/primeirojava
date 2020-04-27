package algaworks.primeirojava.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import algaworks.primeirojava.models.Cliente;

@RestController
@RequestMapping("clientes")
public class ClienteController {

    @GetMapping
    public List<Cliente> listar() {
        var cliente1 = Cliente.builder()
                .id(1L)
                .nome("João")
                .telefone("34 95847-8563")
                .email("joão@gmail.com")
                .build();

        var cliente2 = Cliente.builder()
                .id(1L)
                .nome("João")
                .telefone("34 95847-8563")
                .email("joão@gmail.com")
                .build();

        return List.of(cliente1, cliente2);
    }
}