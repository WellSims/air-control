package br.com.ucsal.aircontrol.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.ucsal.aircontrol.enums.Comando;
import br.com.ucsal.aircontrol.enums.DiaSemana;

@Entity
public class Agenda {

	//PK
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	
	//DE SEGUNDA A SÁBADO
	/*TODO VERIFICAR A VIABILIDADE DE MANTER ENUM
	TALVES COMO UMA STRING A IMPLEMENTAÇÃO SEJA MAIS SIMPLES*/
	@Enumerated(EnumType.STRING)
	public DiaSemana diaSemana;
	
	@NotBlank
	@Size(max = 60)
	public String horario;
	
	//UM REGISTRO DE AGENDA ESTÁ RELACIONADO A UM EQUIPAMENTO
	@OneToOne
	@NotBlank
	public Equipamento equipamento;
	
	@Enumerated(EnumType.STRING)
	/*TODO VERIFICAR A VIABILIDADE DE MANTER ENUM
	TALVES COMO UMA STRING A IMPLEMENTAÇÃO SEJA MAIS SIMPLES*/
	public Comando comando;
	
}