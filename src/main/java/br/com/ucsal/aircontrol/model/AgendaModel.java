package br.com.ucsal.aircontrol.model;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import br.com.ucsal.aircontrol.enums.Comando;
import br.com.ucsal.aircontrol.enums.DiaSemana;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AgendaModel {

	private Long id;
	private String horario;
	private DiaSemana diaSemana;
	private Comando comando;
	
}
