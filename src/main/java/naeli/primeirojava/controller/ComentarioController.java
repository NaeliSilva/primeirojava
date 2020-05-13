package naeli.primeirojava.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import naeli.primeirojava.api.exceptionhandler.EntidadeNaoEncontradaException;
import naeli.primeirojava.domain.repository.OrdemServicoRepository;
import naeli.primeirojava.domain.service.GestaoOrdemServicoService;
import naeli.primeirojava.models.Comentario;
import naeli.primeirojava.models.ComentarioInput;
import naeli.primeirojava.models.ComentarioModel;
import naeli.primeirojava.models.OrdemServico;

@RestController
@RequestMapping("/ordens-servico/{ordemServicoId}/comentarios")
public class ComentarioController {

    @Autowired
    private GestaoOrdemServicoService gestaoOrdemServicoServico;

    @Autowired
    private OrdemServicoRepository OrdemServicoRepository;

    @Autowired
    private ModelMapper modelMepper;

    @GetMapping
    public List<ComentarioModel> listar(@PathVariable Long ordemServicoId) {
        OrdemServico ordemServico = OrdemServicoRepository.findById(ordemServicoId).orElseThrow(() -> new EntidadeNaoEncontradaException("Ordem de serviço não encontrada, minha filha"));

        return toCollectionModel(ordemServico.getComentarios());

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ComentarioModel adicionar(@PathVariable Long ordemServicoId,
            @Valid @RequestBody ComentarioInput comentarioInput) {
        Comentario comentario = gestaoOrdemServicoServico.adicionarComentario(ordemServicoId,
                comentarioInput.getDescricao());

        return toModel(comentario);
    }

    private ComentarioModel toModel(Comentario comentario) {
        return modelMepper.map(comentario, ComentarioModel.class);
    }

    private List<ComentarioModel> toCollectionModel(List<Comentario> comentarios) {
        return comentarios.stream().map(comentario -> toModel(comentario)).collect(Collectors.toList());
    }

}
