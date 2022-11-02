package br.com.ucsal.aircontrol.domain.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import br.com.ucsal.aircontrol.enums.TipoLocalizacao;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/*
 * CRIAR ENUM PARA SALA E LAMI
 * USUÁRIO PREENCHE APENAS O NUMERO DA SALA/LAMI
 * 
 * */

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@Entity
public class Localizacao {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	
	@NotBlank
	@Size(max = 60)
	public String sala;
	
	@NotBlank
	@Size(max = 60)
	public String predio;
	
}
