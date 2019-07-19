package com.example.ProgettoOOPMarcoCarloniMatteoCardinali.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.example.ProgettoOOPMarcoCarloniMatteoCardinali.model.ErasmusData;

/**
 * Classe responsabile del filtraggio dei dati
 */
public class DataFilter
{
	private String field;
	private String type;
	private List<ErasmusData> FilteredData;
	
	/**
	 * Costruttore della classe
	 * 
	 * @param Data		Lista di ErasmusData su cui applicare il filtro
	 * @param Object	JSONObject contenete le informazioni sul filtro da applicare
	 */
	public DataFilter(List<ErasmusData> Data, JSONObject Object)
	{
		FilteredData = new ArrayList<ErasmusData>();
		
		//ottengo la prima chiave di Object, che secondo le regole di sintassi stabilite dal progetto è il nome del campo su cui applicare il filtro
		field = (String) Object.keySet().iterator().next();
		
		Method getter = null;
		
		try 
		{
			getter = ErasmusData.class.getMethod("get" + field.substring(0,1).toUpperCase() + field.substring(1));
		} 
		catch (SecurityException e) 
		{
			e.printStackTrace();
		}
		catch (NoSuchMethodException e)
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Errore, il campo inserito ('" + field + "') non esiste; usando /metadata è possibile reperire gli alias di tutti i campi");
		}
		
		//ottengo il valore relativo alla prima chiave, che è un altro JSONObject
		JSONObject O1 = (JSONObject) Object.get(field);
		
		//ottengo la prima chiave di O1, che secondo le regole di sintassi stabilite dal progetto è il nome del filtro da applicare
		type = (String) O1.keySet().iterator().next();
		
		switch (type)
		{
			case "$in":
			{				
				if ( getter.getReturnType().getName().equals("char") || getter.getReturnType().getName().equals("double") || getter.getReturnType().getName().equals("int") || getter.getReturnType().getName().equals("boolean"))
				{
					throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Errore, il campo('" + field + "') su cui si desidera applicare il filtro non e di tipo String; il filtro '$in' e applicabile solo a campi di tipo stringa");
				}
				
				JSONArray array = (JSONArray) O1.get(type);	
				
				applyIn(Data, getter, array);
				
				break;
			}
			
			case "$nin":
			{
				if ( getter.getReturnType().getName().equals("char") || getter.getReturnType().getName().equals("double") || getter.getReturnType().getName().equals("int") || getter.getReturnType().getName().equals("boolean"))
				{
					throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Errore, il campo('" + field + "') su cui si desidera applicare il filtro non e di tipo String; il filtro '$nin' e applicabile solo a campi di tipo stringa");
				}
				
				JSONArray array = (JSONArray) O1.get(type);
				
				applyNin(Data, getter, array);
				
				break;
			}
			
			
			case "$gt":
			{
				if (getter.getReturnType()!=Double.TYPE && getter.getReturnType()!=Integer.TYPE)
				{
					throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Errore, il campo('" + field + "') su cui si desidera applicare il filtro non e di tipo numerico; il filtro '$gt' e applicabile solo a campi di tipo numerico");
				}
				
				Double O2 = ((Number)O1.get(type)).doubleValue();
				
				try 
				{
					applyGt(Data, getter, O2);
				} 
				catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) 
				{
					e.printStackTrace();
				}
				
				break;
			}
			
			case "$it":
			{
				if (getter.getReturnType()!=Double.TYPE && getter.getReturnType()!=Integer.TYPE)
				{
					throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Errore, il campo('" + field + "') su cui si desidera applicare il filtro non e di tipo numerico; il filtro '$it' e applicabile solo a campi di tipo numerico");
				}
				
				Double O2 = ((Number)O1.get(type)).doubleValue();
				
				try 
				{
					applyIt(Data, getter, O2);
				} 
				catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) 
				{
					e.printStackTrace();
				}
				
				break;
			}
		}
	}
	

	/**
	 * Applica il filtro $in alla lista Data, usando i valori contenuti in Values
	 * 
	 * @param Data		La lista di dati su cui applicare il filtro
	 * @param Getter	Metodo getter necessario per ottenere il valori dei campi degli oggetti di Data
	 * @param Values	Un JSONArray contenente i diversi valori da applicare nel filtro
	 */
	private void applyIn(List<ErasmusData> Data, Method Getter, JSONArray Values)
	{
		String[] V = new String[Values.size()];
		
		for (int i=0; i<Values.size(); i++)
		{
			V[i] = Values.get(i).toString();
		}
		
		String EDvalue = "";
		
		for (ErasmusData ED : Data)
		{
			try 
			{
				EDvalue = (String)Getter.invoke(ED);
			} 
			catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) 
			{
				e.printStackTrace();
			}
			
			boolean recordIsGood=false;
			// controllo se il valore del campo field del record di Data selezionato  
			// e uguale ad uno dei valori(specificati dall'utente) contenuti in values[]
			for(int i=0; i<V.length && !recordIsGood; i++)
			{
				if (EDvalue.equals(V[i]))
				{
					recordIsGood=true;
				}
			}
			
			// se ED e uguale ad uno dei valori specificati, allora viene aggiunto alla lista filtrata 
			if (recordIsGood)
				FilteredData.add(ED);
			
		}
	}
	
	/**
	 * Applica il filtro $nin alla lista Data, usando i valori contenuti in Values
	 * 
	 * @param Data		La lista di dati su cui applicare il filtro
	 * @param Getter	Metodo getter necessario per ottenere il valori dei campi degli oggetti di Data
	 * @param Values	Un JSONArray contenente i diversi valori da applicare nel filtro
	 */
	private void applyNin(List<ErasmusData> Data, Method Getter, JSONArray Values)
	{
		String[] V = new String[Values.size()];
		
		for (int i=0; i<Values.size(); i++)
		{
			V[i] = Values.get(i).toString();
		}
		
		String EDvalue = "";
		
		for (ErasmusData ED : Data)
		{
			try 
			{
				EDvalue = (String)Getter.invoke(ED);
			} 
			catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) 
			{
				e.printStackTrace();
			}
			
			boolean recordIsGood=true;
			// controllo se il valore del campo field del record di Data selezionato  
			// e diverso da tutti i valori(specificati dall'utente) contenuti in values[]
			for(int i=0; i<V.length && recordIsGood; i++)
			{
				if (EDvalue.equals(V[i]))
				{
					recordIsGood=false;
				}
			}
			
			// se ED e diverso a tutti i valori specificati, allora viene aggiunto alla lista filtrata 
			if (recordIsGood)
				FilteredData.add(ED);
			
		}
	}
	
	/**
	 * Applica il filtro $gt alla lista Data, usando il valore value
	 * 
	 * @param Data		La lista di dati su cui applicare il filtro
	 * @param Getter	Metodo getter necessario per ottenere il valori dei campi degli oggetti di Data
	 * @param Value		Il valore in formato Double da usare nell'applicazione del filtro
	 */
	private void applyGt(List<ErasmusData> Data, Method Getter, Double Value) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{
		Double EDValue;
		
		for (ErasmusData ED : Data)
		{
			EDValue = ((Number)Getter.invoke(ED)).doubleValue();
			
			if (EDValue > Value)
			{
				FilteredData.add(ED);
			}
		}
	}
	
	/**
	 * Applica il filtro $it alla lista Data, usando il valore value
	 * 
	 * @param Data		La lista di dati su cui applicare il filtro
	 * @param Getter	Metodo getter necessario per ottenere il valori dei campi degli oggetti di Data
	 * @param Value		Il valore in formato Double da usare nell'applicazione del filtro
	 */
	private void applyIt(List<ErasmusData> Data, Method Getter, Double Value) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{
		Double EDValue;
		
		for (ErasmusData ED : Data)
		{
			EDValue = ((Number)Getter.invoke(ED)).doubleValue();
			
			if (EDValue < Value)
			{
				FilteredData.add(ED);
			}
		}
	}
	
	/**
	 * Restituisce i dati flitrati
	 * 
	 * @return Collection con ErasmusData contenente i dati filtrati
	 */
	public Collection<ErasmusData> getFilteredData()
	{
		return FilteredData;
	}
	
}