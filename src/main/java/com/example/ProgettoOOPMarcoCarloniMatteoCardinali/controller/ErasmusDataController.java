package com.example.ProgettoOOPMarcoCarloniMatteoCardinali.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.ProgettoOOPMarcoCarloniMatteoCardinali.model.ErasmusData;
import com.example.ProgettoOOPMarcoCarloniMatteoCardinali.model.MetaData;
import com.example.ProgettoOOPMarcoCarloniMatteoCardinali.service.ErasmusDataService;

import java.util.Collection;

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
	
	@GetMapping ("/all")
	public Collection<ErasmusData> getAll() 
	{
		return S.getAll();
	}
	
	@GetMapping ("/average/{field}")
	public Double getAverage(@PathVariable String field)
	{
		return S.getAverage(field);
	}
}
