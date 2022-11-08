package it.domenico.banca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.domenico.banca.model.Conto;
import it.domenico.banca.model.Correntista;

@Repository
public interface ContoRepository extends JpaRepository <Conto, Long>{

	List <Conto> findAllContiByCorrentista(Correntista utente);
	
}
