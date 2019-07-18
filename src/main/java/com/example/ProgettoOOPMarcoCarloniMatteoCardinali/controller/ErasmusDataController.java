package com.example.ProgettoOOPMarcoCarloniMatteoCardinali.controller;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ProgettoOOPMarcoCarloniMatteoCardinali.model.ErasmusData;
import com.example.ProgettoOOPMarcoCarloniMatteoCardinali.model.MetaData;
import com.example.ProgettoOOPMarcoCarloniMatteoCardinali.model.Stats;
import com.example.ProgettoOOPMarcoCarloniMatteoCardinali.service.ErasmusDataService;

import java.util.Collection;
import com.example.ProgettoOOPMarcoCarloniMatteoCardinali.model.StringCount;

@RestController
public class ErasmusDataController
{
	@Autowired
	private ErasmusDataService S;
	
	@GetMapping ("/metadata")
	public Collection<MetaData> getMetadata() 
	{
		return S.getMetadata();
	}
	
	@GetMapping ("/data")
	public Collection<ErasmusData> getData() 
	{
		return S.getData();
	}
	
	@PostMapping ("/filter/data")
	public Collection<ErasmusData> getData(@RequestBody String filter) 
	{
		return S.getData(filter);
	}
	
	@GetMapping ("/stats/{field}")
	public Stats getStats(@PathVariable String field)
	{
		return S.getStats(field);
	}
	@GetMapping ("/count/{field}/{name}")
	public StringCount getStringCount(@PathVariable String field,@PathVariable String name)
	{
		return S.StringCounter(field,name);
	}
	
	
}
