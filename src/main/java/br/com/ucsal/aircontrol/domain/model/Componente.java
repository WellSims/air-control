package br.com.ucsal.aircontrol.domain.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.groups.Default;

import br.com.ucsal.aircontrol.domain.ValidationGroups;
import br.com.ucsal.aircontrol.enums.StatusComponente;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/*O COMPONENTE É A PORTA DO ARDUINO QUE LIGA O EQUIPAMENTO*/

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@Entity
public class Componente {

	
	@NotNull(groups = ValidationGroups.ComponenteId.class)
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Size(max = 60)
	private String nome;
	
	@Valid
	@NotNull
	@Enumerated(EnumType.STRING)
	private StatusComponente status;
	
	//EM UMA LOCALIZAÇÃO PODEM COEXISTIR MAIS DE UM COMPONENTE.
	@ManyToOne
	private Localizacao localizacao;
}