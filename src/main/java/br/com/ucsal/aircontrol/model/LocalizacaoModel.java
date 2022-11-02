package br.com.ucsal.aircontrol.model;

import br.com.ucsal.aircontrol.enums.StatusComponente;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocalizacaoModel {

	private Long id;
	private String sala;
	private String predio;
}
