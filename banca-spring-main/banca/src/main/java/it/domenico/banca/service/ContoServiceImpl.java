package it.domenico.banca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.domenico.banca.model.Conto;
import it.domenico.banca.model.Correntista;
import it.domenico.banca.repository.ContoRepository;

@Service
public class ContoServiceImpl implements ContoService{

	@Autowired
	private ContoRepository contoRepository;
	
	@Override
	public List<Conto> getAllConto() {
		// TODO Auto-generated method stub
		return contoRepository.findAll();
	}

	@Override
	public void salvaConto(Conto conto) {
		// TODO Auto-generated method stub
		this.contoRepository.save(conto);
		
	}

	@Override
	public Conto getContoById(long id) {
		// TODO Auto-generated method stub
		Optional<Conto> opzione= contoRepository.findById(id);
		Conto conto = null;
		
		conto= opzione.get();
		
		return conto;
	}

	@Override
	public void cancellaContoById(long id) {
		// TODO Auto-generated method stub
		this.contoRepository.deleteById(id);
		
	}

	@Override
	public List<Conto> findAllContiByCorrentista(Correntista utente) {
		return contoRepository.findAllContiByCorrentista(utente);
		
	}

}
