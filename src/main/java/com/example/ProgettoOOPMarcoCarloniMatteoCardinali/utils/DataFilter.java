package com.example.ProgettoOOPMarcoCarloniMatteoCardinali.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.example.ProgettoOOPMarcoCarloniMatteoCardinali.model.ErasmusData;

public class DataFilter
{
	private String field;
	private String type;
	private String[] values;
	private List<ErasmusData> FilteredData;
	
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
		catch (NoSuchMethodException | SecurityException e) 
		{
			e.printStackTrace();
		}
		
		//ottengo il valore relativo alla prima chiave, che è un altro JSONObject
		JSONObject O1 = (JSONObject) Object.get(field);
		
		//ottengo la prima chiave di Object, che secondo le regole di sintassi stabilite dal progetto è il nome del filtro da applicare
		type = (String) O1.keySet().iterator().next();
		
		switch (type)
		{
			case "$in":
			{
				JSONArray a = (JSONArray) O1.get(type);
				
				values = new String[a.size()];
				
				for (int i=0; i<a.size(); i++)
				{
					values[i] = a.get(i).toString();
				}
				
				String value = null;
				
				for (ErasmusData ED : Data)
				{
					try 
					{
						value = (String)getter.invoke(ED);
					} 
					catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) 
					{
						e.printStackTrace();
					}
					
					boolean recordIsGood=false;
					// controllo se il valore del campo field del record di Data selezionato  
					// e uguale ad uno dei valori(specificati dall'utente) contenuti in values[]
					for(int i=0; i<values.length && !recordIsGood; i++)
					{
						if (value.equals(values[i]))
						{
							recordIsGood=true;
						}
					}
					
					// se ED e uguale ad uno dei valori specificati, allora viene aggiunto alla lista filtrata 
					if (recordIsGood)
						FilteredData.add(ED);
					
				}
				
				break;
			}
			
			case "$nin":
			{
				JSONArray a = (JSONArray) O1.get(type);
				
				values = new String[a.size()];
				
				for (int i=0; i<a.size(); i++)
				{
					values[i] = a.get(i).toString();
				}
				
				String value = null;
				
				for (ErasmusData ED : Data)
				{
					try 
					{
						value = (String)getter.invoke(ED);
					} 
					catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) 
					{
						e.printStackTrace();
					}
					
					boolean recordIsGood=true;
					// controllo se il valore del campo field del record di Data selezionato  
					// e diverso da tutti i valori(specificati dall'utente) contenuti in values[]
					for(int i=0; i<values.length && recordIsGood; i++)
					{
						if (value.equals(values[i]))
						{
							recordIsGood=false;
						}
					}
					
					// se ED e diverso da tuutti i valori specificati, allora viene aggiunto alla lista filtrata 
					if (recordIsGood)
						FilteredData.add(ED);
					
				}
				
				break;
			}
			
			
		}
			
	}

	
	public Collection<ErasmusData> getFilteredData()
	{
		return FilteredData;
	}
	
}