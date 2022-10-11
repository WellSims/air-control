package br.com.ucsal.aircontrol.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ucsal.aircontrol.domain.model.Componente;

@Repository
public interface ComponenteRepository extends JpaRepository<Componente, Long> {

	
	
}
