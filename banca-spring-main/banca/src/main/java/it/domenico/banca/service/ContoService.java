package it.domenico.banca.service;

import java.util.List;

import it.domenico.banca.model.Conto;
import it.domenico.banca.model.Correntista;


public interface ContoService {
	
	List<Conto> getAllConto();
	void salvaConto(Conto conto);
	Conto getContoById(long id);
	void cancellaContoById(long id);
	List<Conto> findAllContiByCorrentista(Correntista utente);

}
