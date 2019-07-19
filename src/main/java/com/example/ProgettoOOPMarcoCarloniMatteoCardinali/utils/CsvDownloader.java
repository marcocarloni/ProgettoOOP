package com.example.ProgettoOOPMarcoCarloniMatteoCardinali.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.LinkOption;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

/**
 * Classe responsabile del download del file csv contenente i dati.
 * 
 */

public class CsvDownloader 
{
	// L'url da cui e possibile reperire il file csv
	private String fileUrl;
	
	/**
	 * Costruttore della classe.
	 * Si occupa di reperire l'url del file csv a partire dal file xml reperito dall'url
	 * specificato alla consegna del progetto
	 */
	public CsvDownloader() 
	{
		try 
		{
			URLConnection openConnection = new URL("http://data.europa.eu/euodp/data/api/3/action/package_show?id=erasmus-mobility-statistics-2008-09").openConnection();
			openConnection.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
			InputStream in = openConnection.getInputStream();		 
			String data = "";
			String line = "";
			 
			try 
			{
				InputStreamReader inR = new InputStreamReader( in );
				BufferedReader buf = new BufferedReader( inR );
				
			    while ( ( line = buf.readLine() ) != null ) 
			    {
			    	data+= line;
			    }
			} 
			finally 
			{
				in.close();		 
			}
						
			JSONObject obj = (JSONObject) JSONValue.parseWithException(data); 
			JSONObject objI = (JSONObject) (obj.get("result"));
			JSONArray objA = (JSONArray) (objI.get("resources"));
			JSONObject o1 = (JSONObject)objA.get(1);; 
			 
			fileUrl = (String)o1.get("url");
			
		} 
		catch (IOException | ParseException e) 
		{
			e.printStackTrace();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}	
	
	
	/**
	 * Effettua il download del file e lo rinomina
	 *
	 * @param fileName	Il nome da dare al file una volta scaricato
	 */
	public void Download(String fileName)
	{
	    try (InputStream in = URI.create(fileUrl).toURL().openStream()) 
	    {
	    	//Il file verra scaricato solo nel caso in cui non sia gia stato scaricato in precedenza
	    	//(questo puo richiedere anche molto tempo, fino a diversi minuti)
	    	if(!Files.exists(Paths.get(fileName), LinkOption.NOFOLLOW_LINKS ))
	    	{
	    		Files.copy(in, Paths.get(fileName));
	    	} 
	    }
	    catch (Exception e)
	    {
	    	e.printStackTrace();
	    }
	}
}