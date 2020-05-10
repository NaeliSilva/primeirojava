package algaworks.primeirojava.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import algaworks.primeirojava.domain.repository.OrdemServicoRepository;
import algaworks.primeirojava.domain.service.GestaoOrdemServicoService;
import algaworks.primeirojava.models.OrdemServico;
import algaworks.primeirojava.models.OrdemServicoModel;


@RestController
@RequestMapping("/ordens-servico")
public class OrdemServicoController {

    @Autowired
    private GestaoOrdemServicoService gestaoOrdemServicoService;

    @Autowired
    private OrdemServicoRepository ordemServicoRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrdemServico criar(@Valid @RequestBody OrdemServico ordemServico) {
        return gestaoOrdemServicoService.criar(ordemServico);
    }

    @GetMapping
    public java.util.List<OrdemServico> Listar() {
        return ordemServicoRepository.findAll();
    }

    @GetMapping("/{ordemServicoId}")
    public ResponseEntity<OrdemServicoModel> buscar(@PathVariable Long ordemServicoId) {
      Optional<OrdemServico> ordemServico = ordemServicoRepository.findById(ordemServicoId);

        if (ordemServico.isPresent()){
            OrdemServicoModel model = new OrdemServicoModel();
            model.setId(ordemServico.get().getId());
            model.setDescricao(ordemServico.get().getDescricao());
            //...
            return ResponseEntity.ok (model);
        }

        return ResponseEntity.notFound().build();

    }


}