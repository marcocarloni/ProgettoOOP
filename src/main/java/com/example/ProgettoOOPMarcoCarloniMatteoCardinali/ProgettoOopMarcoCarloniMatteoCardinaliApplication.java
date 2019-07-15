package com.example.ProgettoOOPMarcoCarloniMatteoCardinali;

import java.io.IOException;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.ProgettoOOPMarcoCarloniMatteoCardinali.model.ErasmusData;
import com.example.ProgettoOOPMarcoCarloniMatteoCardinali.utils.CsvDownloader;
import com.example.ProgettoOOPMarcoCarloniMatteoCardinali.utils.CsvParser;

@SpringBootApplication
public class ProgettoOopMarcoCarloniMatteoCardinaliApplication {

	public static List<ErasmusData> dati;
	
	public static void main(String[] args) {
		CsvDownloader.Download();
		try {
			dati=CsvParser.Parsing();
			
		}
		catch(IOException E){
			E.printStackTrace();
		}
		SpringApplication.run(ProgettoOopMarcoCarloniMatteoCardinaliApplication.class, args);
	}

}
