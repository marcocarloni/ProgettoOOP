package com.example.ProgettoOOPMarcoCarloniMatteoCardinali.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ProgettoOOPMarcoCarloniMatteoCardinali.model.ErasmusData;
import com.example.ProgettoOOPMarcoCarloniMatteoCardinali.model.MetaData;
import com.example.ProgettoOOPMarcoCarloniMatteoCardinali.model.Stats;
import com.example.ProgettoOOPMarcoCarloniMatteoCardinali.service.ErasmusDataService;

import java.util.Collection;
import com.example.ProgettoOOPMarcoCarloniMatteoCardinali.model.StringCount;

/**
 * Classe controller che si occupa di gestire le richieste 
 * tramite api get/post con opportune risposte.
 * 
 * I metodi con l'annotazione Spring "@GetMapping" e "@postMapping" restituiscono 
 * le risposte (in formato json) alle richieste specificate 
 *
 */
@RestController
public class ErasmusDataController
{
	@Autowired
	private ErasmusDataService S;
	
	/**
	 * Restituisce l'elenco dei metadata
	 * 
	 * @return Collezione di oggetti MetaData
	 */
	@GetMapping ("/metadata")
	public Collection<MetaData> getMetadata() 
	{
		return S.getMetadata();
	}
	
	/**
	 * Restituisce l'elenco di tutti i dati
	 * 
	 * @return Collezione di oggetti ErasmusData
	 */
	@GetMapping ("/data")
	public Collection<ErasmusData> getData() 
	{
		return S.getData();
	}
	
	/**
	 * Restituisce l'elenco dei dati dopo avervi applicato il filtro filter
	 * 
	 * @param filter	Filtro da applicare ai dati
	 * @return			Collezione di oggetti ErasmusData soddisfacenti le condizioni del filtro
	 */
	@PostMapping ("/filter/data")
	public Collection<ErasmusData> getData(@RequestBody String filter) 
	{
		return S.getData(filter);
	}
	
	/**
	 * Restituisce le statistiche relative al campo field
	 * 
	 * @param field	Il campo su cui calcolare le statistiche
	 * @return		Le statistiche racchiuse in un oggetto Stats
	 */
	@GetMapping ("/stats/{field}")
	public Stats getStats(@PathVariable String field)
	{
		return S.getStats(field);
	}
	
	/**
	 * Restituisce il conteggio dei record che hanno name come valore del campo field
	 * 
	 * @param field	Il campo i cui valori saranno controllati
	 * @param name	Il valore di tipo String da cercare nel campo field
	 * @return		Un oggetto di tipo StringCount contenente e informazioni relative al conteggio
	 */
	@GetMapping ("/count/{field}/{name}")
	public StringCount getStringCount(@PathVariable String field,@PathVariable String name)
	{
		return S.StringCounter(field,name);
	}
	
	
}
