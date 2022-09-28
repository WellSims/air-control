package br.com.ucsal.aircontrol.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.ucsal.aircontrol.enums.StatusComponente;

/*O COMPONENTE É A PORTA DO ARDUINO QUE LIGA O EQUIPAMENTO*/

@Entity
public class Componente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Size(max = 60)
	private String nome;
	
	@Enumerated(EnumType.STRING)
	/*TODO VERIFICAR A VIABILIDADE DE MANTER ENUM
	TALVES COMO UMA STRING A IMPLEMENTAÇÃO SEJA MAIS SIMPLES*/
	private StatusComponente status;
	
	//EM UMA LOCALIZAÇÃO PODEM COEXISTIR MAIS DE UM COMPONENTE.
	@ManyToOne
	@NotBlank
	private Localizacao localizacao;
}