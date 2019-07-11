package utils;
import java.io.*;
import java.net.URL;
import java.net.URI;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import model.ErasmusData;
import model.MetaData;

import org.json.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;
import org.springframework.boot.json.BasicJsonParser;
import java.lang.*;
import java.lang.reflect.Field;



/**
 * Classe per la gestione del parsing del dataset precedentemente scaricato attraverso la classe "CsvDownloader"
 */

public class CsvParser 
{
	
	private static ArrayList<ErasmusData> ED = new ArrayList<ErasmusData>();
	final static String COMMA_DELIMITER = ";";

	static {
		
			String url = "http://data.europa.eu/euodp/data/api/3/action/package_show?id=erasmus-mobility-statistics-2008-09";
			
			try {
					readdata(url);
				} catch (IOException | ParseException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
			
			try {
					insertdata("Dataset.csv");
				} catch (Exception e) {
					e.printStackTrace();
				}	
			}
	
	
	/** Metodo che effettua il download dei dati dall'URL passatogli, effettua un primo controllo di esistenza del file 
	 * e tramite il try scarica i dati.
	 * @param url
	 * @param fileName
	 * @throws Exception
	 */
	public static void download(String url, String fileName) throws Exception
	{
	    File f = new File(fileName);
	    /**
	     *Qui andrebbe il controllo per vedere se esistono già i file e crearli in caso contrario.
	     *Attualmente se i file già esistono vengono cancellati per essere poi ricreati.
	     */
	    if (f.exists()) {
	    	f.delete();
	    }
	    
		try (InputStream in = URI.create(url).toURL().openStream()) {
			Files.copy(in, Paths.get(fileName));
		}
		System.out.println("Download effettuato");
	}
	
	/** Metodo che effettua la lettura dei dati dall'URL passatogli, crea due stringhe data e line le quali si occupano di leggere riga
	 *  per riga il file dell'url. Line, tramite il while controlla l'andata a capo del file di testo(quindi la fine della riga).
	 *   Successivamente, tramite il for
	 *  vado a cercare nel file le parole "format","url","csv" da cui poi vado a scaricare i dati 
	 * @param url url dal quale aprire il file da leggere ed analizzare
	 * @throws Exception
	 */
	public static void readdata(String url) throws Exception
	{
		URLConnection openConnection = new URL(url).openConnection();
		openConnection.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
		InputStream in = openConnection.getInputStream();
		String data = "";
		String line = "";
		try {
			InputStreamReader inR = new InputStreamReader(in);
			BufferedReader buf = new BufferedReader(inR);
			
				while ((line = buf.readLine()) != null) { 
					data+= line;
				}
			} finally {
				in.close();
				}
		 
		JSONObject obj = (JSONObject) JSONValue.parseWithException(data);
		JSONObject objI = (JSONObject) (obj.get("result"));
		JSONArray objA = (JSONArray) (objI.get("resources"));
		
		for(Object o: objA) {                 
		    if (o instanceof JSONObject) {
		        JSONObject o1 = (JSONObject)o; 
		        String format = (String)o1.get("format");
		        String urlD = (String)o1.get("url");
		        if(format.equals("csv"))
		        {
		        	download(urlD, "Dataset.csv");
		        }
		    }
		}
		System.out.println("Lettura effettuata");
	}
	
	/**
	 * Questa funzione effettua il parsing dei dati appena scaricati.
	 * Interpreta le stringhe e crea gli oggetti assegnando i parametri agli attributi.
	 * @param file
	 * @throws Exception
	 */
	
	public static void insertdata(String file) throws Exception
	{
		List<List<String>> records = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = br.readLine()) != null) { 
				String[] values = line.split(COMMA_DELIMITER); 
				records.add(Arrays.asList(values));
				ED.add(new ErasmusData(values[0], values[1], Integer.parseInt(values[2]), (values[3]).charAt(0),values[4],Integer.parseInt( values[5])
						,Integer.parseInt( values[6]),Integer.parseInt(values[7]) ,(values[8]).charAt(0), values[9], values[10], values[11],values[12],
						(values[13]).charAt(0), (values[14]).charAt(0), 
						Integer.parseInt(values[15]),Integer.parseInt(values[16]),(values[17]).charAt(0), values[18], values[19],
						Integer.parseInt(values[20]),Integer.parseInt(values[21]) ,Integer.parseInt(values[22]),Integer.parseInt(values[23]),Integer.parseInt(values[24]),
						(values[25]).charAt(0), values[26], values[27],Double.parseDouble(values[28]),Double.parseDouble(values[29]),
						(values[30]).charAt(0),values[31]));
			}
		br.close();
		} catch (IOException i) {
			i.printStackTrace();
			return;
		}
		System.out.println("Parsing effettuato");
	}	
}




