package br.com.ucsal.aircontrol.domain.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;

import br.com.ucsal.aircontrol.domain.ValidationGroups;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/*O EQUIPAMENTO É O AR-CONDICIONADO*/

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@Entity
public class Equipamento {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Size(max = 60)
	private String nome;
	
	@OneToMany(mappedBy = "equipamento", cascade=CascadeType.ALL)
	private List<Agenda> agenda = new ArrayList<>();
	
	//UM EQUIPAMENTO ESTÁ RELACIONADO A UM COMPONENTE
	@ConvertGroup(from = Default.class, to=ValidationGroups.ComponenteId.class)
	@Valid
	@NotNull
	@OneToOne
	private Componente componente;

	public Agenda adicionarAgenda(Agenda agenda) {
		Agenda novaAgenda = new Agenda();
		novaAgenda = agenda;
		novaAgenda.setEquipamento(this);

		this.getAgenda().add(novaAgenda);
		
		return novaAgenda;
	}
	
}
