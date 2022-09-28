package br.com.ucsal.aircontrol.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.ucsal.aircontrol.domain.model.Equipamento;
import br.com.ucsal.aircontrol.domain.repository.EquipamentoRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class EquipamentoService {

	private EquipamentoRepository equipamentoRepository;
	
	//Essa anotação declara que o método
	//deve ser executado em uma transação e
	//em caso de erro todas as operações da transação
	//devem ser descartadas. TUDO OU NADA!
	@Transactional
	public Equipamento salvar(Equipamento equipamento) {
		return equipamentoRepository.save(equipamento);
	}
	
	@Transactional
	public void excluir(Long equipamentoId) {
		equipamentoRepository.deleteById(equipamentoId);
	}
}
