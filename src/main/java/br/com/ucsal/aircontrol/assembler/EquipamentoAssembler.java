package br.com.ucsal.aircontrol.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import br.com.ucsal.aircontrol.domain.model.Equipamento;
import br.com.ucsal.aircontrol.model.EquipamentoModel;
import br.com.ucsal.aircontrol.model.input.EquipamentoInput;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class EquipamentoAssembler {

	private ModelMapper modelMapper;
	
	public EquipamentoModel toModel(Equipamento equipamento) {
		return modelMapper.map(equipamento, EquipamentoModel.class);
	}
	
	public List<EquipamentoModel> toCollectionModel(List<Equipamento> equipamentos){
		return equipamentos.stream()
				.map(this::toModel)
				.collect(Collectors.toList());
	}
	
	public Equipamento toEntity(EquipamentoInput equipamentoInput ) {
		return modelMapper.map(equipamentoInput, Equipamento.class);
	}
	
}
