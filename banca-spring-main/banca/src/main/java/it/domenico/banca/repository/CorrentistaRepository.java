package it.domenico.banca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.domenico.banca.model.Correntista;

@Repository
public interface CorrentistaRepository extends JpaRepository <Correntista, Long>{


	
}
