package br.com.ucsal.aircontrol.model;

import br.com.ucsal.aircontrol.enums.StatusComponente;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ComponenteModel {

	private Long id;
	private String nome;
	private StatusComponente status;
}
