package naeli.primeirojava.domain.service;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import naeli.primeirojava.api.exceptionhandler.EntidadeNaoEncontradaException;
import naeli.primeirojava.controller.NegocioException;
import naeli.primeirojava.domain.repository.ClienteRepository;
import naeli.primeirojava.domain.repository.ComentarioRepository;
import naeli.primeirojava.domain.repository.OrdemServicoRepository;
import naeli.primeirojava.models.Cliente;
import naeli.primeirojava.models.Comentario;
import naeli.primeirojava.models.OrdemServico;
import naeli.primeirojava.models.StatusOrdemServico;

@Service
public class GestaoOrdemServicoService {

    @Autowired
    private OrdemServicoRepository ordemServicoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ComentarioRepository comentarioRepository;

    public OrdemServico criar(final OrdemServico ordemServico) {
        final Cliente cliente = clienteRepository.findById(ordemServico.getCliente().getId())
                .orElseThrow(() -> new NegocioException("Cliente não encontrado"));

        ordemServico.setCliente(cliente);
        ordemServico.setStatus(StatusOrdemServico.ABERTA);
        ordemServico.setDataAbertura(OffsetDateTime.now());

        return ordemServicoRepository.save(ordemServico);

    }

    public void finalizar(final Long ordemServicoId) {
        final OrdemServico ordemServico = buscar(ordemServicoId);

        ordemServico.setStatus(StatusOrdemServico.FINALIZADA);

    }

    public Comentario adicionarComentario(final Long ordemServicoId, final String descricao) {
        final OrdemServico ordemServico = buscar(ordemServicoId);

        final Comentario comentario = new Comentario();
        comentario.setDataEnvio(OffsetDateTime.now());
        comentario.setDescricao(descricao);
        comentario.setOrdemServico(ordemServico);

        return comentarioRepository.save(comentario);

    }

    private OrdemServico buscar(Long ordemServicoId) {
        return ordemServicoRepository.findById(ordemServicoId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Ordem de serviço não encontrada, moço"));

    }

}
