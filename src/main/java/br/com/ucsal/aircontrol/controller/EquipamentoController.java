package br.com.ucsal.aircontrol.controller;


import java.util.List;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.ucsal.aircontrol.assembler.EquipamentoAssembler;
import br.com.ucsal.aircontrol.domain.model.Componente;
import br.com.ucsal.aircontrol.domain.model.Equipamento;
import br.com.ucsal.aircontrol.domain.repository.EquipamentoRepository;
import br.com.ucsal.aircontrol.domain.service.ComponenteService;
import br.com.ucsal.aircontrol.domain.service.EquipamentoService;
import br.com.ucsal.aircontrol.model.ComponenteModel;
import br.com.ucsal.aircontrol.model.EquipamentoModel;
import br.com.ucsal.aircontrol.model.input.EquipamentoInput;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/equipamentos")
public class EquipamentoController {
	
	private EquipamentoService equipamentoService;
	private EquipamentoRepository equipamentoRepository;
	private ComponenteService componenteService;
	private EquipamentoAssembler equipamentoAssembler;
	
	@GetMapping
	public List<EquipamentoModel> listar() {
		return equipamentoAssembler.toCollectionModel(equipamentoRepository.findAll());
	}
	
	@GetMapping("/{equipamentoId}")
	public ResponseEntity<EquipamentoModel> buscar(@PathVariable Long equipamentoId) {
		return equipamentoRepository.findById(equipamentoId)
				.map(equipamento -> ResponseEntity.ok(equipamentoAssembler.toModel(equipamento)))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public EquipamentoModel salvar(@Valid @RequestBody EquipamentoInput equipamentoInput) {
		Equipamento novoEquipamento = equipamentoAssembler.toEntity(equipamentoInput);
		Componente componente = componenteService.buscar(novoEquipamento.getComponente().getId());
		novoEquipamento.setComponente(componente);
		Equipamento equipamentoConvertido = equipamentoService.salvar(novoEquipamento); 
		return equipamentoAssembler.toModel(equipamentoConvertido);
	}
	
	@PutMapping("/{equipamentoId}")
	public ResponseEntity<Equipamento> atualizar(@PathVariable Long equipamentoId,  
			@RequestBody Equipamento equipamento){
		
		if (!equipamentoRepository.existsById(equipamentoId)) {
			return ResponseEntity.notFound().build();
		}
		
		equipamento.setComponente(equipamentoService.buscar(equipamentoId).getComponente());
		equipamento.setId(equipamentoId);
		equipamento = equipamentoService.salvar(equipamento);
		
		return ResponseEntity.ok(equipamento);
	}
	
	@DeleteMapping("/{equipamentoId}")
	public ResponseEntity<Void> excluir(@PathVariable Long equipamentoId){
		if (!equipamentoRepository.existsById(equipamentoId)) {
			return ResponseEntity.notFound().build();
		}
		equipamentoService.excluir(equipamentoId);
		return ResponseEntity.noContent().build();
	}
	
}
