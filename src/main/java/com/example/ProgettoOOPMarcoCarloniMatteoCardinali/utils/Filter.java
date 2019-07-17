package com.example.ProgettoOOPMarcoCarloniMatteoCardinali.utils;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.simple.*;

import com.example.ProgettoOOPMarcoCarloniMatteoCardinali.model.ErasmusData;

public class Filter
{
	private String field;
	private String type;
	private String[] values;
	

	public Filter(List<ErasmusData> Data, JSONObject Object)
	{
		
		field = (String) Object.keySet().iterator().next();
		
		
		/*
		field = (String) Object.keys().next();
		
		try 
		{
			JSONObject f = Object.getJSONObject(field);
			type = (String) f.keys().next();
			JSONArray a = f.getJSONArray((String) f.keys().next());
			
			for(int i=0; i< a.length(); i++)
			{
				values[i] = a.getString(i);
			}
		} 
		catch (JSONException e) 
		{
			e.printStackTrace();
		}
		*/
		
		
		System.out.println(field);
		//System.out.println(type);
		//System.out.println(values[0]);
		//System.out.println(values[1]);
	}
	
	
}