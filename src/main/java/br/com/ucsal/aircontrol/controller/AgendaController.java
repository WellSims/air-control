package br.com.ucsal.aircontrol.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.ucsal.aircontrol.assembler.AgendaAssembler;
import br.com.ucsal.aircontrol.domain.model.Agenda;
import br.com.ucsal.aircontrol.domain.model.Equipamento;
import br.com.ucsal.aircontrol.domain.service.AgendaService;
import br.com.ucsal.aircontrol.domain.service.EquipamentoService;
import br.com.ucsal.aircontrol.model.AgendaModel;
import br.com.ucsal.aircontrol.model.input.AgendaInput;
import lombok.AllArgsConstructor;

@CrossOrigin(origins = "*")
@AllArgsConstructor
@RestController
@RequestMapping("/equipamentos/{equipamentoId}/agendas")
public class AgendaController {

	private AgendaService agendaService;
	private AgendaAssembler agendaAssembler;
	private EquipamentoService equipamentoService;
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public AgendaModel salvar(@PathVariable Long equipamentoId, @Valid @RequestBody AgendaInput agendaInput) {
		
		Agenda novaAgenda = agendaService.salvar(equipamentoId,  agendaAssembler.toEntity(agendaInput));
		return agendaAssembler.toModel(novaAgenda);
	}
	
	@GetMapping
	public List<AgendaModel> listar(@PathVariable Long equipamentoId){
		Equipamento equipamento = equipamentoService.buscar(equipamentoId);
		return agendaAssembler.toCollectionModel(equipamento.getAgenda());
	}
	
}
