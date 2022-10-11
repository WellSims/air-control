package br.com.ucsal.aircontrol.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ucsal.aircontrol.domain.model.Equipamento;

@Repository
public interface EquipamentoRepository extends JpaRepository<Equipamento, Long>{

	List<Equipamento> findByNome(String nome);
	List<Equipamento> findByNomeContaining(String nome);
	
}