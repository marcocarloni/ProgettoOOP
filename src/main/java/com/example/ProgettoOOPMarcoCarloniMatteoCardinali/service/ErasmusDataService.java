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
import org.springframework.stereotype.Service;

import com.example.ProgettoOOPMarcoCarloniMatteoCardinali.model.ErasmusData;
import com.example.ProgettoOOPMarcoCarloniMatteoCardinali.model.MetaData;
import com.example.ProgettoOOPMarcoCarloniMatteoCardinali.model.Stats;
import com.example.ProgettoOOPMarcoCarloniMatteoCardinali.utils.CsvDownloader;
import com.example.ProgettoOOPMarcoCarloniMatteoCardinali.utils.CsvParser;
import com.example.ProgettoOOPMarcoCarloniMatteoCardinali.utils.Filter;

@Service
public class ErasmusDataService
{
	private List<ErasmusData> Data;
	private String Meta[];
	
	public ErasmusDataService()
	{
		String fileName = "Dataset.csv";
		
		CsvDownloader downloader = new CsvDownloader();
		downloader.Download(fileName);
		
		try 
		{
			CsvParser parser = new CsvParser(fileName);
			Meta=parser.getMetaData();
			Data=parser.getData();
		}
		catch(IOException E)
		{
			E.printStackTrace();
		}
	}
	
	public Stats getStats(String field) 
	{
		
		Stats statistiche = new Stats();
		
		double sum = 0;
		double min = 0;
		double max = 0;
		double avg = 0;
		double devStd = 0;
		int count = Data.size();
		
		Field[] fields= ErasmusData.class.getDeclaredFields();
		Method getter = null;
		
		boolean flag=false;
		
		try
		{
			// cerco l'attributo indicato nel parametro field tra gli attributi della classe ErasmusData e poi recupero il metodo get corrispondente
			for (int i=0; i<fields.length && !flag; i++) 
			{
				String alias = fields[i].getName();
				
				//anche se field viene scritto con o senza maiuscole, l'attributo corrispondente viene comunque trovato
				if (alias.equalsIgnoreCase(field))
				{
					flag = true;
					getter = ErasmusData.class.getMethod("get" + alias.substring(0,1).toUpperCase() + alias.substring(1));
				}
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
		catch (NoSuchMethodException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e)
		{
			e.printStackTrace();
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
	
	public Collection<ErasmusData> getData(JSONObject filter)
	{
		Filter f = new Filter(Data, filter);
		return Data;
	}
	
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
		Field[] fields= ErasmusData.class.getDeclaredFields();
		Method getter = null;
		boolean flag=false;
		try
		{
			// cerco l'attributo indicato nel parametro field tra gli attributi della classe ErasmusData e poi recupero il metodo get corrispondente
			for (int i=0; i<fields.length && !flag; i++) 
			{
				String alias = fields[i].getName();
							
				//anche se field viene scritto con o senza maiuscole, l'attributo corrispondente viene comunque trovato
				if (alias.equalsIgnoreCase(field))
				{
					flag = true;
					getter = ErasmusData.class.getMethod("get" + alias.substring(0,1).toUpperCase() + alias.substring(1));
				}
			}
			
			
			for(ErasmusData ED: Data)
			{
				
				if(((String) getter.invoke(ED)).equalsIgnoreCase(name))
				{
					count++;
				}
				 
				
			}
		}
		catch (NoSuchMethodException |IllegalAccessException|  IllegalArgumentException | InvocationTargetException e)
		{
			e.printStackTrace();
		}
		
		return new StringCount(field,count);
	}
	
}
