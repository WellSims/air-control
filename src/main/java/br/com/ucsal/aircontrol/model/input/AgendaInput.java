package br.com.ucsal.aircontrol.model.input;

import javax.validation.constraints.NotBlank;

import br.com.ucsal.aircontrol.enums.Comando;
import br.com.ucsal.aircontrol.enums.DiaSemana;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AgendaInput {

	private Long id;
	@NotBlank
	private String horario;
	private DiaSemana diaSemana;
	private Comando comando;
	
}
