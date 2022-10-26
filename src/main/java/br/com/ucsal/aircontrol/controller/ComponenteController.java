package br.com.ucsal.aircontrol.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.ucsal.aircontrol.domain.model.Componente;
import br.com.ucsal.aircontrol.domain.model.Equipamento;
import br.com.ucsal.aircontrol.domain.repository.ComponenteRepository;
import br.com.ucsal.aircontrol.domain.service.ComponenteService;
import lombok.AllArgsConstructor;

@CrossOrigin(origins = "*")
@AllArgsConstructor
@RequestMapping("/componentes")
@RestController
public class ComponenteController {
	
	private ComponenteService componenteService;
	private ComponenteRepository componenteRepository;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Componente salvar(@Valid @RequestBody Componente componente) {
		return componenteService.salvar(componente);
	}
	
	@GetMapping
	public List<Componente> listar(){
		return componenteRepository.findAll();
	}

	@PutMapping("/{componenteId}")
	public ResponseEntity<Componente> atualizar(@PathVariable Long componenteId,  
			@RequestBody Componente componente){
		
		if (!componenteRepository.existsById(componenteId)) {
			return ResponseEntity.notFound().build();
		}
		
		componente.setId(componenteId);
		componente = componenteService.salvar(componente);
		
		return ResponseEntity.ok(componente);
	}
	
	@GetMapping("/{entregaId}")
	public ResponseEntity<Componente> buscar(@PathVariable Long entregaId){
		return componenteRepository.findById(entregaId)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{componenteId}")
	public ResponseEntity<Void> excluir(@PathVariable Long componenteId){
		if (!componenteRepository.existsById(componenteId)) {
			return ResponseEntity.notFound().build();
		}
		componenteService.excluir(componenteId);
		return ResponseEntity.noContent().build();
	}
	
}
