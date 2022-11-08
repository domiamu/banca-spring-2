package it.domenico.banca.service;

import java.util.List;

import it.domenico.banca.model.Correntista;

public interface CorrentistaService {
	
	List<Correntista> getAllCorrentisti();
	void salvaCorrentista(Correntista correntista);
	Correntista getCorrentistaById(long id);
	void cancellaCorrentistaById(long id);

}
