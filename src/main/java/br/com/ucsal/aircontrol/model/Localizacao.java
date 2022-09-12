package br.com.ucsal.aircontrol.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.ucsal.aircontrol.enums.TipoLocalizacao;

/*
 * criar enum para SALA E LAMI
 * USUÁRIO PREENCHE APENAS O NUMERO DA SALA/LAMI
 * 
 * */

@Entity
public class Localizacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	
	@Enumerated(EnumType.STRING)
	/*TODO VERIFICAR A VIABILIDADE DE MANTER ENUM
	TALVES COMO UMA STRING A IMPLEMENTAÇÃO SEJA MAIS SIMPLES*/
	public TipoLocalizacao tipo;
	
	@NotBlank
	@Size(max = 60)
	public String numero;
	
	@NotBlank
	@Size(max = 60)
	public String predio;
	
}
