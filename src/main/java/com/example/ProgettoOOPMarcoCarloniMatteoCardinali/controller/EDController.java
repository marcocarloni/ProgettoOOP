package com.example.ProgettoOOPMarcoCarloniMatteoCardinali.controller;

import  model.MetaData;
import model.ErasmusData;
import model.Stat;
import model.StringCounter;
import utils.CsvParser;
import utils.Filters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ProgettoOOPMarcoCarloniMatteoCardinali.ProgettoOopMarcoCarloniMatteoCardinaliApplication;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
public class EDController
{
	@GetMapping ("/metadata")
	public Collection getMetadata() 
	{
		int i=0;
		List <MetaData> Meta = new ArrayList();
		String meta[]=CsvParser.metad();
		Field[] field= ErasmusData.class.getDeclaredFields();
		for (Field o : field) {
            MetaData newMeta = new MetaData();
            newMeta.setType(o.getType().getSimpleName());
            newMeta.setSourceField(meta[i]);
            Meta.add(newMeta);
            i+=1;
        }
        return Meta;
	}
	
	@GetMapping ("/all")
	public Collection getAll() 
	{
		return ProgettoOopMarcoCarloniMatteoCardinaliApplication.dati ;
	}
	
}
