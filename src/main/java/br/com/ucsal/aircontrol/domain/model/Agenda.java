package br.com.ucsal.aircontrol.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.ucsal.aircontrol.enums.Comando;
import br.com.ucsal.aircontrol.enums.DiaSemana;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@Entity
public class Agenda {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	@Column(name="dia_semana")
	private DiaSemana diaSemana;
	
	@NotBlank
	@Size(max = 60)
	private String horario;
	
	//UM REGISTRO DE AGENDA ESTÁ RELACIONADO A UM EQUIPAMENTO
	@ManyToOne
	private Equipamento equipamento;
	
	/*TODO VERIFICAR A VIABILIDADE DE MANTER ENUM
	TALVEZ COMO UMA STRING A IMPLEMENTAÇÃO SEJA MAIS SIMPLES*/
	@Enumerated(EnumType.STRING)
	private Comando comando;
	
}