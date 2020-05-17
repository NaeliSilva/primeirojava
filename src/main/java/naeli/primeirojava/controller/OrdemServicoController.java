package naeli.primeirojava.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import naeli.primeirojava.domain.repository.OrdemServicoRepository;
import naeli.primeirojava.domain.service.GestaoOrdemServicoService;
import naeli.primeirojava.models.OrdemServico;
import naeli.primeirojava.models.OrdemServicoInputModel;
import naeli.primeirojava.models.OrdemServicoModel;

@RestController
@RequestMapping("/ordens-servico")
public class OrdemServicoController {

    private static final Object OrdemServicoInputModel = null;

    @Autowired
    private GestaoOrdemServicoService gestaoOrdemServicoService;

    @Autowired
    private OrdemServicoRepository ordemServicoRepository;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrdemServicoModel criar(@Valid @RequestBody OrdemServicoInputModel ordemServicoInputModel) {
        OrdemServico ordemServico = toEntity(ordemServicoInputModel);
        return (OrdemServicoModel) toModel(gestaoOrdemServicoService.criar(ordemServico));
    }

    @GetMapping
    public java.util.List<OrdemServico> Listar() {
        return ordemServicoRepository.findAll();
    }

    @GetMapping("/{ordemServicoId}")
    public ResponseEntity<OrdemServicoModel> buscar(@PathVariable Long ordemServicoId) {
        Optional<OrdemServico> ordemServico = ordemServicoRepository.findById(ordemServicoId);

        if (ordemServico.isPresent()) {
            OrdemServicoModel ordemServicoModel = toModel(ordemServico.get());
            return ResponseEntity.ok(ordemServicoModel);
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{ordemServicoId}/finalizada")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void finalizar(@PathVariable Long ordemServicoId) {
        gestaoOrdemServicoService.finalizar(ordemServicoId);
    }

    private OrdemServicoModel toModel(OrdemServico ordemServico) {
        return modelMapper.map(ordemServico, OrdemServicoModel.class);
    }

    private List<Object> toCollectionModel(List<OrdemServico> ordensServico) {
        return ordensServico.stream().map(ordemServico -> toModel(ordemServico)).collect(Collectors.toList());

    }

    private Object toModel(OrdemServicoModel ordemServico) {
        return null;

    }

    private OrdemServico toEntity(OrdemServicoInputModel ordemServicoInputModel) {
        return modelMapper.map(OrdemServicoInputModel, OrdemServico.class);
    }

}
