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

import br.com.ucsal.aircontrol.domain.model.Localizacao;
import br.com.ucsal.aircontrol.domain.repository.LocalizacaoRepository;
import br.com.ucsal.aircontrol.domain.service.LocalizacaoService;
import lombok.AllArgsConstructor;

@CrossOrigin(origins = "*")
@AllArgsConstructor
@RequestMapping("/localizacoes")
@RestController
public class LocalizacaoController {

	public LocalizacaoRepository localizacaoRepository;
	public LocalizacaoService localizacaoService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Localizacao salvar(@Valid @RequestBody Localizacao componente) {
		return localizacaoService.salvar(componente);
	}
	
	@GetMapping
	public List<Localizacao> listar(){
		return localizacaoRepository.findAll();
	}
	
	@PutMapping("/{localizacaoId}")
	public ResponseEntity<Localizacao> atualizar(@PathVariable Long localizacaoId,  
			@RequestBody Localizacao localizacao){
		
		if (!localizacaoRepository.existsById(localizacaoId)) {
			return ResponseEntity.notFound().build();
		}
		
		localizacao.setId(localizacaoId);
		localizacao = localizacaoService.salvar(localizacao);
		
		return ResponseEntity.ok(localizacao);
	}
	
	@GetMapping("/{localizacaoId}")
	public ResponseEntity<Localizacao> buscar(@PathVariable Long localizacaoId){
		return localizacaoRepository.findById(localizacaoId)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{localizacaoId}")
	public ResponseEntity<Void> excluir(@PathVariable Long localizacaoId){
		if (!localizacaoRepository.existsById(localizacaoId)) {
			return ResponseEntity.notFound().build();
		}
		localizacaoService.excluir(localizacaoId);
		return ResponseEntity.noContent().build();
	}
	
}
