package algaworks.primeirojava.controller;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import algaworks.primeirojava.domain.service.GestaoOrdemServicoService;
import algaworks.primeirojava.models.Comentario;
import algaworks.primeirojava.models.ComentarioInput;
import algaworks.primeirojava.models.ComentarioModel;

@RestController
@RequestMapping("/ordens-servico/{ordemServicoId}/comentarios")
public class ComentarioController {

@Autowired
private GestaoOrdemServicoService gestaoOrdemServicoServico;

@Autowired
private ModelMapper modelMepper;

    @PostMapping
    @ResponseStatus (HttpStatus.CREATED)
    public ComentarioModel adicionar(@PathVariable Long ordemServicoId, @Valid @RequestBody ComentarioInput comentarioInput) {
        Comentario comentario = gestaoOrdemServicoServico.adicionarComentario(ordemServicoId, comentarioInput.getDescricao());

        return toModel(comentario);
    }

    private ComentarioModel toModel(Comentario comentario) {
        return modelMepper.map(comentario, ComentarioModel.class);
    }
}
