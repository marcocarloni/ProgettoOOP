package com.example.ProgettoOOPMarcoCarloniMatteoCardinali.service;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ProgettoOOPMarcoCarloniMatteoCardinali.model.ErasmusData;
import com.example.ProgettoOOPMarcoCarloniMatteoCardinali.model.MetaData;
import com.example.ProgettoOOPMarcoCarloniMatteoCardinali.utils.CsvDownloader;
import com.example.ProgettoOOPMarcoCarloniMatteoCardinali.utils.CsvParser;

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
	
	public Double getAverage(String field) 
	{
		
		double sum=0;
		int n=0;
		
		Field[] fields= ErasmusData.class.getDeclaredFields();
		Method getter = null;
		
		boolean flag=false;
		
		try
		{
			for (int i=0; i<fields.length && !flag; i++) 
			{
				String alias = fields[i].getName();
				if (alias.equalsIgnoreCase(field))
				{
					flag = true;
					getter = ErasmusData.class.getMethod("get" + alias.substring(0,1).toUpperCase() + alias.substring(1));
				}
			}
			
			for (ErasmusData ED : Data)
			{
				sum += (double)((Integer)getter.invoke(ED)).intValue();
				n++;
			}
		}
		catch (NoSuchMethodException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e)
		{
			e.printStackTrace();
		}
		
		return sum/n;
	}
	
	public Collection<ErasmusData> getAll()
	{
		return Data;
	}
	
	public Collection<MetaData> getMetadata() 
	{
		int i=0;
		List <MetaData> MetaObjects = new ArrayList<MetaData>();
		Field[] fields= ErasmusData.class.getDeclaredFields();
		
		for (Field f : fields) 
		{
            MetaData newMeta = new MetaData();
            newMeta.setAlias(f.getName());
            newMeta.setSourceField(Meta[i]);
            newMeta.setType(f.getType().getSimpleName());
            MetaObjects.add(newMeta);
            i++;
        }
		
        return MetaObjects;
	}
	
}
