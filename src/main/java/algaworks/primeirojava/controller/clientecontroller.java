package algaworks.primeirojava.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.*;
import lombok.var;
import algaworks.primeirojava.models.Cliente;

@RestController
public class clientecontroller {

    @GetMapping("/clientes")
    public List<Cliente> listar() {
        var cliente1 = new Cliente();
        cliente1.setId(1L);
        cliente1.setNome("João");
        cliente1.setTelefone("34 95847-8563");
        cliente1.setEmail("joão@gmail.com");
        
        var cliente2 = new Cliente();
        cliente2.setId(2L);
        cliente2.setNome("João");
        cliente2.setTelefone("34 95847-8563");
        cliente2.setEmail("joão@gmail.com");

        return Arrays.asList(cliente1,cliente2);
    }
}