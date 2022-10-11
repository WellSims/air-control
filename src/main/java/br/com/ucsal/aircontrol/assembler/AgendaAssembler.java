package br.com.ucsal.aircontrol.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import br.com.ucsal.aircontrol.domain.model.Agenda;
import br.com.ucsal.aircontrol.domain.model.Equipamento;
import br.com.ucsal.aircontrol.model.AgendaModel;
import br.com.ucsal.aircontrol.model.EquipamentoModel;
import br.com.ucsal.aircontrol.model.input.AgendaInput;
import br.com.ucsal.aircontrol.model.input.EquipamentoInput;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class AgendaAssembler {

	private ModelMapper modelMapper;
	
	public Agenda toEntity(AgendaInput agendaInput ) {
		return modelMapper.map(agendaInput, Agenda.class);
	}
	
	public List<AgendaModel> toCollectionModel(List<Agenda> agenda){
		return agenda.stream()
				.map(this::toModel)
				.collect(Collectors.toList());
	}
	
	public AgendaModel toModel(Agenda agenda) {
		return modelMapper.map(agenda, AgendaModel.class);
	}
}
