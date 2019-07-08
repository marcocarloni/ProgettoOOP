package model;
/**
* Classe modellante dei dati contenente gli attributi presenti nel file .csv .
* In particolare questa è la classe modellante dei dati riferiti alla sottoclasse
* istitution che estende la classe corporation.	
*/
public class WorkPlacement extends Corporation 
{
	private char enterpriseSize;
	private char typeWorkSector;
	private	int consortiumAgreementNumber;
	
	/**
	 * Costruttore della classe richiamando quello della superclasse.
	 * 
	 * @param code
	 * @param country
	 * @param enterpriseSize
	 * @param typeWorkSector
	 * @param consortiumAgreementNumber
	 */
	
	public WorkPlacement(String code, String country,char enterpriseSize,char typeWorkSector,int consortiumAgreementNumber) 
	{
		super(code, country);
		this.enterpriseSize=enterpriseSize;
		this.typeWorkSector=typeWorkSector;
		this.consortiumAgreementNumber=consortiumAgreementNumber;
	}
	
	//Get
    public char getEnterpriseSize() { return enterpriseSize;  }
    public char getTypeWorkSector() { return typeWorkSector; }
    public int getConsortiumAgreementNumber() { return consortiumAgreementNumber; }
    
    @Override
    public String toString() 
    {
        return "Work Placement{" +
                "Code=" + code +
                ", Country ='" + country +
                "', Enterprise size ="+ enterpriseSize +
                ", Type work sector ="+ typeWorkSector +
                "Consortium Agreement Number ="+consortiumAgreementNumber+
                '}';
    }
}
