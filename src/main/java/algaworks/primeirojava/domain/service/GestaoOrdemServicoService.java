package algaworks.primeirojava.domain.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import algaworks.primeirojava.domain.repository.OrdemServicoRepository;
import algaworks.primeirojava.domain.repository.*;
import algaworks.primeirojava.models.OrdemServico;
import algaworks.primeirojava.models.StatusOrdemServico;

@Service
public class GestaoOrdemServicoService {

    @Autowired
    private OrdemServicoRepository ordemServicoRepository;

    public OrdemServico criar(OrdemServico ordemServico) {
        ordemServico.setStatus(StatusOrdemServico.ABERTA);
        ordemServico.setDataAbertura(LocalDateTime.now());

        return ordemServicoRepository.save(ordemServico);

    }
}