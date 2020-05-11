package algaworks.primeirojava.domain.service;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import algaworks.primeirojava.domain.repository.OrdemServicoRepository;
import algaworks.primeirojava.controller.NegocioException;
import algaworks.primeirojava.domain.repository.*;
import algaworks.primeirojava.models.Cliente;
import algaworks.primeirojava.models.Comentario;
import algaworks.primeirojava.models.OrdemServico;
import algaworks.primeirojava.models.StatusOrdemServico;

@Service
public class GestaoOrdemServicoService {

    @Autowired
    private OrdemServicoRepository ordemServicoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ComentarioRepository comentarioRepository;

    public OrdemServico criar(OrdemServico ordemServico) {
        Cliente cliente = clienteRepository.findById(ordemServico.getCliente().getId()).orElseThrow(() -> new NegocioException("Cliente não encontrado"));

        ordemServico.setCliente(cliente);
        ordemServico.setStatus(StatusOrdemServico.ABERTA);
        ordemServico.setDataAbertura(OffsetDateTime.now());

        return ordemServicoRepository.save(ordemServico);

    }
    
    public Comentario adicionarComentario(Long ordemServicoId, String descricao) {
        OrdemServico ordemServico = ordemServicoRepository.findById(ordemServicoId).orElseThrow(() -> new NegocioException("Ordem de serviço não encontrada, moço"));

        Comentario comentario = new Comentario();
        comentario.setDataEnvio(OffsetDateTime.now()); 
        comentario.setDescricao(descricao);
        comentario.setOrdemServico(ordemServico);
        
        return comentarioRepository.save(comentario);

    }

}
