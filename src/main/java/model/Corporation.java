package model;
import java.io.Serializable;
/**
* Classe modellante dei dati contenente gli attributi presenti nel file .csv .
* In particolare questa è la classe modellante dei dati riferiti alla superclasse corporation,
* estesa dalle classi istitution e workplacement.	
*/

public class Corporation implements Serializable 
{
	protected String code;
	protected String country;
	
	/**
	 * Costruttore della classe.
	 * 
	 * @param code
	 * @param country
	 */
	
	public Corporation(String code,String country)
	{
		this.code=code;
		this.country=country;
	}
	
	//Get
    public String getCode() { return code;  }
    public String getCountry() { return country; }
    
    @Override
    public String toString() 
    {
        return "Corporation{" +
                "Code=" + code +
                ", Country ='" + country +
                '}';
    }
}

