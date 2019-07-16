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
 * Classe per la gestione dei dati che vengono ricevuti al primo avvio partendo dal
 * file json assegnato: dal json ci si riconduce all'url contenente il file .csv d' interesse.
 */

public class CsvDownloader 
{

	private String fileUrl;
	
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
	 * Effettua il download del file indicato e lo rinomina
	 *
	 * @param fileName	Il nome da dare al file una volta scaricato
	 */
	public void Download(String fileName)
	{
	    try (InputStream in = URI.create(fileUrl).toURL().openStream()) 
	    {
	    	if(Files.exists(Paths.get(fileName), LinkOption.NOFOLLOW_LINKS ))
	    	{
	    		System.out.println("Il dataset � gia stato scaricato in precedenza...");
	    	}
	    	else Files.copy(in, Paths.get(fileName));
	    }
	    catch (Exception e)
	    {
	    	e.printStackTrace();
	    }
	    
	}
}