package model;
import java.io.Serializable;

/**
 *  Classe modellante dei dati contenente gli attributi presenti nel file .csv
 *
 *  Il file proposto contiene dati inerenti l'attività di Erasmus di alcuni studenti europei nel
 *  corso dell'anno 2008.
 */

public class ErasmusData implements Serializable
{
	private String homeInstitution;
	private String countryHome;
	private int age;
	private char sex;
	private String nationality;
	private int subjectArea;
	private int levelStudy;
	private int yearsPrior;
	private char mobility;
	private String hostInstitution;
	private String countryHost;
	private String workPlacement;
	private String countryWP;
	private char enterpriseSize;
	private char typeWorkSector;
	private int studyLenght;
	private int workLenght;
	private boolean shortDuration;
	private String studyStartDate;
	private String workStartDate;
	private	int consortiumAgreementNumber;
	private int ECTSCreditStudy;
	private int ECTSCreditWork;
	private int totalCredits;
	private int sevSupplement;
	private char taughtHostLang;
	private	String languageTaught;
	private	String lingPreparation;
	private float studyGrant;
	private float workGrant;
	private char previousPartecipation;
	private String qualificationHost;

  	 /**
	 * Costruttore della classe.
	 * 
	 * @param homeInstitution
	 * @param countryHome
	 * @param age
	 * @param sex
	 * @param nationality
	 * @param subjectArea
	 * @param levelStudy
	 * @param yearsPrior
	 * @param mobility
	 * @param hostInstitution
	 * @param countryHost
	 * @param workPlacement
	 * @param countryWP
	 * @param enterpriseSize
	 * @param typeWorkSector
	 * @param studyLenght
	 * @param workLenght
	 * @param shortDuration
	 * @param studyStartDate
	 * @param workStartDate
	 * @param consortiumAgreementNumber
	 * @param ECTSCreditStudy
	 * @param ECTSCreditWork
	 * @param totalCredits
	 * @param sevSupplement
	 * @param taughtHostLang
	 * @param languageTaught
	 * @param lingPreparation
	 * @param studyGrant
	 * @param workGrant
	 * @param previousPartecipation
	 * @param qualificationHost
	 */

	public ErasmusData(String homeInstitution,String countryHome,int age,char sex,String nationality,int subjectArea,int levelStudy,int yearsPrior,char mobility, String 	hostInstitution,String countryHost,String workPlacement,String countryWP,char 	enterpriseSize,char 	typeWorkSector,int studyLenght,int workLenght,boolean shortDuration,String 	studyStartDate,String 	workStartDate,int consortiumAgreementNumber,int ECTSCreditStudy,int ECTSCreditWork,int 	totalCredits,int sevSupplement,char taughtHostLang,String languageTaught,String 	lingPreparation,float studyGrant,float workGrant,char previousPartecipation,String 	qualificationHost)
	{
		this.homeInstitution = homeInstitution;
		this.countryHome = countryHome;
		this.age = age;
		this.sex = sex;
		this.nationality =nationality ;
		this.subjectArea = subjectArea;
		this.levelStudy = levelStudy;
		this.yearsPrior = yearsPrior;
		this.mobility = mobility;
		this.hostInstitution =hostInstitution ;
		this.countryHost = countryHost;
		this.workPlacement =workPlacement ;
		this.countryWP = countryWP;
		this.enterpriseSize = enterpriseSize;
		this.typeWorkSector = typeWorkSector;
		this.studyLenght = studyLenght;
		this.workLenght = workLenght;
		this.shortDuration =shortDuration ;
		this.studyStartDate = studyStartDate;
		this.workStartDate = workStartDate;
		this.consortiumAgreementNumber =consortiumAgreementNumber ;
		this.ECTSCreditStudy = ECTSCreditStudy;
		this.ECTSCreditWork = ECTSCreditWork;
		this.totalCredits = totalCredits;
		this.sevSupplement = sevSupplement;
		this.taughtHostLang =taughtHostLang ;
		this.languageTaught = languageTaught;
		this.lingPreparation =lingPreparation ;
		this.studyGrant = studyGrant;
		this.workGrant = workGrant;
		this.previousPartecipation =previousPartecipation ;
		this.qualificationHost = qualificationHost;

	}

	//get
	public String getHomeInsitution() {return homeInstitution;}
	public String getCountryHome() {return countryHome;}
	public int getAge() {return age;}
	public char getSex() {return sex;}
	public String getNationality() {return nationality;}
	public int getSubjectArea() {return subjectArea;}
	public int getLevelStudy() {return levelStudy;}
	public int getYearsPrior() {return yearsPrior;}
	public char getMobility() {return mobility;}
	public String getHostInstitution() {return hostInstitution;}
	public String getCountryHost() {return countryHost;}
	public String getWorkPlacement() {return workPlacement;}
	public String getCountryWP() {return countryWP;}
	public char getEnterpriseSize() {return enterpriseSize;}
	public char getTypeWorkSector() {return typeWorkSector;}
	public int getStudyLenght() {return subjectArea;}
	public int getWorkLenght() {return workLenght;}
	public boolean getShortDuration() {return shortDuration;}
	public String getStudyStartDate() {return studyStartDate;}
	public String getWorkStartDate() {return workStartDate;}
	public int getConsortiumAgreementNumber() {return consortiumAgreementNumber;}
	public int getECTSCreditStudy() {return ECTSCreditStudy;}
	public int getECTSCreditWork() {return ECTSCreditWork;}
	public int getTotalCredits() {return totalCredits;}
	public int getSevSupplement() {return sevSupplement;}
	public char getTaughtHostLang() {return taughtHostLang;}
	public String getLanguageTaught() {return languageTaught;}
	public String getLingPreparation() {return lingPreparation;}
	public float getStudyGrant() {return studyGrant;}
	public float getWorkGrant() {return workGrant;}
	public char getPreviousPartecipation() {return previousPartecipation;}
	public String getQualificationHost() {return qualificationHost;}

	@Override
	public String toString() 
		{
	        return "Erasmus{" +
	                "Home institution=" + homeInstitution +
	                ", Country Home='" + countryHome +
	                ", Age=" + age +
	                ", Sex=" + sex +
	                ", Nationality=" + nationality+
	                ", SubjectArea=" + subjectArea+
	                ", Level Study=" + levelStudy +
	                ", Years Prior=" + yearsPrior+
               		", Mobility=" + mobility +
               		", Host institution=" + hostInstitution +
	                ", Country Host='" + countryHost +
	                ", Work Placement=" + workPlacement +
	                ", Country Work Placement='" + countryWP +
	                ", Enterprise size ="+ enterpriseSize +
	                ", Type work sector ="+ typeWorkSector +
	                ", Study Lenght=" + studyLenght +
	                ", Work Lenght=" + workLenght +
	                ", Is a short duration project? =" + shortDuration +
	                ", Study start Date=" + studyStartDate +
	                ", Placement start Date=" + workStartDate +
	                ", Consortium Agreement Number ="+consortiumAgreementNumber+
	                ", ECTS Credit Study=" + ECTSCreditStudy +
	                ", ECTS Credit Work=" + ECTSCreditWork +
	                ", Total credits=" + totalCredits +
	                ", Sev Supplement=" + sevSupplement +
	                ", Taught Host Language=" + taughtHostLang +
	                ", Language Taught=" + languageTaught +
	                ", Ling Preparation=" + lingPreparation +
	                ", Study Grant=" + studyGrant +
	                ", Placement Grant=" + workGrant +
	                ", Previous Partecipation=" + previousPartecipation +
	                ", Qualification=" + qualificationHost +
	                '}';
	    }
}