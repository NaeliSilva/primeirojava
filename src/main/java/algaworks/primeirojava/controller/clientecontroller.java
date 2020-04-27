package algaworks.primeirojava.controller;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import algaworks.primeirojava.domain.repository.ClienteRepository;
import algaworks.primeirojava.models.Cliente;

@RestController
public class clientecontroller {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/clientes")
    public List<Cliente> listar() {
        // return clienteRepository.findAll();
        return clienteRepository.findByNomeContaining("Silva");
    }
}