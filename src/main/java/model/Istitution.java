package model;
/**
* Classe modellante dei dati contenente gli attributi presenti nel file .csv .
* In particolare questa è la classe modellante dei dati riferiti alla sottoclasse
* istitution che estende la classe corporation.	
*/
public class Istitution extends Corporation
{

	/**
	 * Uso il costruttore della superclasse.
	 * 
	 * @param code
	 * @param country
	 */
	
	public Istitution(String code, String country) 
	{
		super(code, country);
	}
	
	@Override
    public String toString() 
	{
        return "Istitution{" +
                "Code=" + code +
                ", Country ='" + country +
                '}';
	}
}
