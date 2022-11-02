package br.com.ucsal.aircontrol.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.ucsal.aircontrol.domain.exception.NegocioException;
import br.com.ucsal.aircontrol.domain.model.Componente;
import br.com.ucsal.aircontrol.domain.model.Localizacao;
import br.com.ucsal.aircontrol.domain.repository.LocalizacaoRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class LocalizacaoService {

	
	private LocalizacaoRepository localizacaoRepository;
	
	@Transactional
	public Localizacao salvar(Localizacao localizacao) {
		return localizacaoRepository.save(localizacao);
	}
	
	@Transactional
	public Localizacao buscar(Long localizacaoId) {
		return localizacaoRepository.findById(localizacaoId)
				.orElseThrow(()->new NegocioException("Localizacao não encontrada"));
	}
	
	@Transactional
	public void excluir(Long localizacaoId) {
		localizacaoRepository.deleteById(localizacaoId);
	}
	
}
