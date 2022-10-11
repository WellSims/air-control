package br.com.ucsal.aircontrol.model.input;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ComponenteIdInput {

	@NotNull
	private Long id;
}
