package com.example.ProgettoOOPMarcoCarloniMatteoCardinali.service;
import com.example.ProgettoOOPMarcoCarloniMatteoCardinali.model.StringCount;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.ProgettoOOPMarcoCarloniMatteoCardinali.model.ErasmusData;
import com.example.ProgettoOOPMarcoCarloniMatteoCardinali.model.MetaData;
import com.example.ProgettoOOPMarcoCarloniMatteoCardinali.model.Stats;
import com.example.ProgettoOOPMarcoCarloniMatteoCardinali.utils.CsvDownloader;
import com.example.ProgettoOOPMarcoCarloniMatteoCardinali.utils.CsvParser;
import com.example.ProgettoOOPMarcoCarloniMatteoCardinali.utils.DataFilter;

/**
 * Classe responsabile delle operazioni di calcolo e filtraggio sui dati
 */
@Service
public class ErasmusDataService
{
	private List<ErasmusData> Data;
	private String Meta[];
	
	/**
	 * Costruttore della classe
	 */
	public ErasmusDataService()
	{
		String fileName = "Dataset.csv";
		
		//Effettuo il download del dataset
		CsvDownloader downloader = new CsvDownloader();
		downloader.Download(fileName);
		
		try 
		{
			//Effettuo il parsing del dataset e  ottengo i dati e i metadati
			CsvParser parser = new CsvParser(fileName);
			Meta=parser.getMetaData();
			Data=parser.getData();
		}
		catch(IOException E)
		{
			E.printStackTrace();
		}
	}
	
	/**
	 * Esegue il calcolo delle statistiche per il campo specificato
	 * e le restituisce attraverso un oggetto di tipo Stats
	 * 
	 * @param field Il campo di cui si richiedono le statistiche (deve essere di tipo numerico)
	 * @return		Un oggetto di tipo Stats, contenente le statistiche relative al campo richiesto
	 */
	public Stats getStats(String field) 
	{
		Stats statistiche = new Stats();
		
		double sum = 0;
		double min = 0;
		double max = 0;
		double avg = 0;
		double devStd = 0;
		int count = Data.size();
				
		Method getter = null;
		
		try
		{
			// Conoscendo la sintassi dei metodi getter posso ottenere il metodo get corrispondente al campo indicato; il campo deve pero essere inserito cosi come e chiamato nella classe ErasmusData
			getter = ErasmusData.class.getMethod("get" + field.substring(0,1).toUpperCase() + field.substring(1));
			
			if (getter.getReturnType()!=Double.TYPE && getter.getReturnType()!=Integer.TYPE)
			{
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Errore, il campo che si sta cercando di inserire('" + field + "') non è di tipo numerico; le statistiche sono calcolabili solo su campi numerici");
			}
			
			min=((Number)getter.invoke(Data.get(0))).doubleValue();
			max=((Number)getter.invoke(Data.get(0))).doubleValue();
			
			double x = 0;
			
			for (ErasmusData ED : Data)
			{
				x = ((Number)getter.invoke(ED)).doubleValue();
				
				if (x>max)
					max = x;
				if (x<min)
					min = x;
				
				sum += x;
			}
			
			avg = sum/count;
			double temp = 0;
			
			for (ErasmusData ED : Data)
			{
				x = ((Number)getter.invoke(ED)).doubleValue();
				
				temp += Math.pow(x-avg, 2);
			}
			
			devStd = Math.sqrt(temp/count);
		}
		catch ( IllegalAccessException | IllegalArgumentException | InvocationTargetException e)
		{
			e.printStackTrace();
		}
		catch (NoSuchMethodException e)
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Errore, il campo inserito ('" + field + "') non esiste; usando /metadata è possibile reperire gli alias di tutti i campi");
		}
		
		statistiche.setField(field);
		statistiche.setCount(count);
		statistiche.setSum(sum);
		statistiche.setMin(min);
		statistiche.setMax(max);
		statistiche.setAvg(avg);
		statistiche.setDevStd(devStd);
		
		return statistiche;
	}
	
	
	/**
	 * Restituisce tutti i dati
	 * 
	 * @return Collection di ErasmusData contenente tutti i record del dataset
	 */
	public Collection<ErasmusData> getData()
	{
		return Data;
	}
	
	/**
	 * Restituisce i dati filtrati
	 * 
	 * @param filter Il filtro da applicare ai dati
	 * @return		 I dati filtrati
	 */
	public Collection<ErasmusData> getData(String filter)
	{
		JSONParser parser = new JSONParser();
		JSONObject jsonFilter = null;
		try 
		{
			jsonFilter = (JSONObject) parser.parse(filter);
		} 
		catch (ParseException e) 
		{
			e.printStackTrace();
		}
		
		DataFilter f = new DataFilter(Data, jsonFilter);
		
		return f.getFilteredData();
	}
	
	
	/**
	 * 
	 * 
	 * @return
	 */
	public Collection<MetaData> getMetadata() 
	{
		List <MetaData> MetaObjects = new ArrayList<MetaData>();
		Field[] fields= ErasmusData.class.getDeclaredFields();
		
		for (int i=0; i<fields.length; i++) 
		{
            MetaData newMeta = new MetaData();
            newMeta.setAlias(fields[i].getName());
            newMeta.setSourceField(Meta[i]);
            newMeta.setType(fields[i].getType().getSimpleName());
            MetaObjects.add(newMeta);
        }
		
        return MetaObjects;
	}
	
	public StringCount StringCounter(String field,String name)
	{
		int count=0;		
		Method getter = null;
		
		try
		{
			getter = ErasmusData.class.getMethod("get" + field.substring(0,1).toUpperCase() + field.substring(1));
			
			if ( getter.getReturnType().getName().equals("char") || getter.getReturnType().getName().equals("D") || getter.getReturnType().getName().equals("I") || getter.getReturnType().getName().equals("Z"))
			{
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Errore, il campo che si sta cercando di inserire('" + field + "') non è di tipo stringa; il conteggio e effettuabile solo su campi di tipo stringa");
			}
			
			for(ErasmusData ED: Data)
			{
				System.out.println((String) getter.invoke(ED));
				System.out.println(name);
				
				if(((String) getter.invoke(ED)).equals(name))
				{
					count++;
				}
			}
		}
		catch (IllegalAccessException|  IllegalArgumentException | InvocationTargetException e)
		{
			e.printStackTrace();
		}
		catch (NoSuchMethodException e)
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Errore, il campo inserito ('" + field + "') non esiste; usando /metadata è possibile reperire gli alias di tutti i campi");
		}
		
		return new StringCount(field,count);
	}	
}