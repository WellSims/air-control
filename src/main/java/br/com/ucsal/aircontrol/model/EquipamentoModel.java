package br.com.ucsal.aircontrol.model;

import java.util.List;

import br.com.ucsal.aircontrol.domain.model.Agenda;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EquipamentoModel {
	
	private Long id;
	private String nome;
	private List<AgendaModel> agenda;
	private ComponenteModel componente;
	
}
