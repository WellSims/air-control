package br.com.ucsal.aircontrol.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.ucsal.aircontrol.domain.exception.NegocioException;
import br.com.ucsal.aircontrol.domain.model.Componente;
import br.com.ucsal.aircontrol.domain.repository.ComponenteRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ComponenteService {

	private ComponenteRepository componenteRepository; 
	
	@Transactional
	public Componente salvar(Componente componente) {
		return componenteRepository.save(componente);
	}
	
	@Transactional
	public Componente buscar(Long componenteId) {
		return componenteRepository.findById(componenteId)
				.orElseThrow(()->new NegocioException("Componente não encontrado"));
	}
	
	@Transactional
	public void excluir(Long componenteId) {
		componenteRepository.deleteById(componenteId);
	}

}