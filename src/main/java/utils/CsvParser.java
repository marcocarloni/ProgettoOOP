package utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;

import model.ErasmusData;

public class CsvParser 
{
	private static String MetaData[];
	/**
	 * Converte una stringa in un intero, gestendo anche le stringhe nulle
	 *
	 * @param  s    la stringa da convertire
	 * @return      l'intero corrispondente
	 */
	public static int StringToInt(String s)
	{
		int n=0;
		
		if (!s.isEmpty())
		{
			n=Integer.parseInt(s);
		}
		
		return n;
	}
	
	/**
	 * Converte una stringa in un carattere, gestendo anche le stringhe nulle
	 *
	 * @param  s    la stringa da convertire
	 * @return      il carattere corrispondente
	 */
	public static char StringToChar(String s)
	{
		char c='\0';
		
		if (!s.isEmpty())
		{
			c=s.charAt(0);
		}
		
		return c;
	}
	
	/**
	 * Effettua il parsing riga per riga di tutti i record del dataset
	 *
	 * @return      una lista di oggetti MetaData corrispondenti a tutti gli elementi del dataset
	 */
	public static List<ErasmusData> Parsing() throws IOException 
	{
		//crea un oggetto CSVReader, responsabile della lettura e del parsing del dataset
		CSVReader reader = new CSVReader(new FileReader("Dataset.csv"), ';');
		
		List<ErasmusData> dati = new ArrayList<ErasmusData>();
		String[] record = null;
		
		//la prima riga contiene i nomi dei campi del dataset, percui viene saltata
		 MetaData = reader.readNext();
		
		while((record = reader.readNext()) != null)
		{
			ErasmusData elemento = new ErasmusData(
					record[0],
					record[1],
					StringToInt(record[2]),
					StringToChar(record[3]),
					record[4],
					StringToInt(record[5]),
					record[6],
					StringToInt(record[7]),
					StringToChar(record[8]),
					record[9],
					record[10],
					record[11],
					record[12],
					StringToChar(record[13]),
					StringToChar(record[14]),
					Double.parseDouble(record[15]),
					Double.parseDouble(record[16]),
					StringToChar(record[17]),
					record[18],
					record[19],
					record[20],
					StringToInt(record[21]),
					StringToInt(record[22]),
					StringToInt(record[23]),
					Double.parseDouble(record[24]),
					StringToChar(record[25]),
					record[26],
					record[27],
					Double.parseDouble(record[28]),
					Double.parseDouble(record[29]),
					StringToChar(record[30]),
					record[31]);
					dati.add(elemento);
		}
		
		reader.close();
		return dati;
	}
	public static String[] metad()
	{
		return MetaData;
	}


}