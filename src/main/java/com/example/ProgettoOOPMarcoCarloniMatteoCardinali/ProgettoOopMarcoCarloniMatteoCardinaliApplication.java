package com.example.ProgettoOOPMarcoCarloniMatteoCardinali;

import java.io.IOException;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import model.ErasmusData;
import utils.CsvDownloader;
import utils.CsvParser;

@SpringBootApplication
public class ProgettoOopMarcoCarloniMatteoCardinaliApplication {

	public static void main(String[] args) {
		CsvDownloader.Download();
		try {
			List<ErasmusData> dati=CsvParser.Parsing();
		}
		catch(IOException E){
			E.printStackTrace();
		}
		SpringApplication.run(ProgettoOopMarcoCarloniMatteoCardinaliApplication.class, args);
	}

}
