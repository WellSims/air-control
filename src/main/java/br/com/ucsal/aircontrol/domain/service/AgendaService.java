package br.com.ucsal.aircontrol.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.ucsal.aircontrol.domain.exception.NegocioException;
import br.com.ucsal.aircontrol.domain.model.Agenda;
import br.com.ucsal.aircontrol.domain.model.Equipamento;
import br.com.ucsal.aircontrol.domain.repository.EquipamentoRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class AgendaService {

	private EquipamentoRepository equipamentoRepository;
	
	@Transactional
	public Agenda salvar(Long equipamentoId, Agenda agenda) {
		Equipamento equipamento = equipamentoRepository.findById(equipamentoId)
				.orElseThrow(() -> new NegocioException("Equipamento não encontrado."));
		
		return equipamento.adicionarAgenda(agenda);
	}
	
}
