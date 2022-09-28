package br.com.ucsal.aircontrol.domain.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import br.com.ucsal.aircontrol.enums.TipoLocalizacao;

/*
 * criar enum para SALA E LAMI
 * USUÁRIO PREENCHE APENAS O NUMERO DA SALA/LAMI
 * 
 * */

//@Entity
public class Localizacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	
	@NotBlank
	@Enumerated(EnumType.STRING)
	public TipoLocalizacao tipo;
	
	@NotBlank
	@Size(max = 60)
	public String numero;
	
	@NotBlank
	@Size(max = 60)
	public String predio;
	
	@OneToMany(mappedBy = "localizacao", cascade = CascadeType.ALL)
	private List<Componente> componentes = new ArrayList<>();
}
