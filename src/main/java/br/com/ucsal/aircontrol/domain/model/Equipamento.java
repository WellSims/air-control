package br.com.ucsal.aircontrol.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/*O EQUIPAMENTO É O AR-CONDICIONADO*/

@Entity
public class Equipamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Size(max = 60)
	private String nome;

	//UM EQUIPAMENTO ESTÁ RELACIONADO A UM COMPONENTE
	@OneToOne
	@NotBlank
	private Componente componente;
}
