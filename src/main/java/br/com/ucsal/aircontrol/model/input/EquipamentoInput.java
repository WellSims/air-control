package br.com.ucsal.aircontrol.model.input;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EquipamentoInput {

	private Long id;
	private String nome;
	
	@Valid
	@NotNull
	private ComponenteIdInput componente;
	
}