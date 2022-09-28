package br.com.ucsal.aircontrol.controller;


import java.util.List;
import javax.validation.Valid;
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

import br.com.ucsal.aircontrol.domain.model.Equipamento;
import br.com.ucsal.aircontrol.domain.repository.EquipamentoRepository;
import br.com.ucsal.aircontrol.domain.service.EquipamentoService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/equipamentos")
public class EquipamentoController {
	
	private EquipamentoService equipamentoService;
	private EquipamentoRepository equipamentoRepository;
	
	@GetMapping
	public List<Equipamento> listar() {
		return equipamentoRepository.findAll();
	}
	
	@GetMapping("/{equipamentoId}")
	public ResponseEntity<Equipamento> buscar(@PathVariable Long equipamentoId) {
		return equipamentoRepository.findById(equipamentoId)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Equipamento salvar(@Valid @RequestBody Equipamento equipamento) {
		return equipamentoService.salvar(equipamento);
	}
	
	@PutMapping("/{equipamentoId}")
	public ResponseEntity<Equipamento> atualizar(@PathVariable Long equipamentoId, @Valid  
			@RequestBody Equipamento equipamento){
		if (!equipamentoRepository.existsById(equipamentoId)) {
			return ResponseEntity.notFound().build();
		}
		
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
