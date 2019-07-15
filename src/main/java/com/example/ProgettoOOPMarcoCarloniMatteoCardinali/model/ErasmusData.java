package com.example.ProgettoOOPMarcoCarloniMatteoCardinali.model;

/**
 *  Classe modellante dei dati contenente gli attributi presenti nel file .csv
 *
 *  Il file proposto contiene dati inerenti l'attività di Erasmus di alcuni studenti europei nel
 *  corso dell'anno 2008.
 */

public class ErasmusData 
{		
	private String homeInstitution;
	private String countryHome;
	private int age;
	private char sex;
	private String nationality;
	private int subjectArea;
	private String levelStudy;
	private int yearsPrior;
	private char mobility;
	private String hostInstitution;
	private String countryHost;
	private String workPlacement;
	private String countryWP;
	private char enterpriseSize;
	private char typeWorkSector;
	private double studyLenght;
	private double workLenght;
	private char shortDuration;
	private String studyStartDate;
	private String workStartDate;
	private	String consortiumAgreementNumber;
	private int ECTSCreditStudy;
	private int ECTSCreditWork;
	private int totalCredits;
	private double sevSupplement;
	private char taughtHostLang;
	private	String languageTaught;
	private	String lingPreparation;
	private double studyGrant;
	private double workGrant;
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
	
	public ErasmusData(String homeInstitution, String countryHome, int age, char sex, String nationality, int subjectArea,
			String levelStudy, int yearsPrior, char mobility, String hostInstitution, String countryHost,
			String workPlacement, String countryWP, char enterpriseSize, char typeWorkSector, double studyLenght,
			double workLenght, char shortDuration, String studyStartDate, String workStartDate,
			String consortiumAgreementNumber, int ECTSCreditStudy, int ECTSCreditWork, int totalCredits, double sevSupplement,
			char taughtHostLang, String languageTaught, String lingPreparation, double studyGrant, double workGrant,
			char previousPartecipation, String qualificationHost) 
	{
		this.homeInstitution = homeInstitution;
		this.countryHome = countryHome;
		this.age = age;
		this.sex = sex;
		this.nationality = nationality;
		this.subjectArea = subjectArea;
		this.levelStudy = levelStudy;
		this.yearsPrior = yearsPrior;
		this.mobility = mobility;
		this.hostInstitution = hostInstitution;
		this.countryHost = countryHost;
		this.workPlacement = workPlacement;
		this.countryWP = countryWP;
		this.enterpriseSize = enterpriseSize;
		this.typeWorkSector = typeWorkSector;
		this.studyLenght = studyLenght;
		this.workLenght = workLenght;
		this.shortDuration = shortDuration;
		this.studyStartDate = studyStartDate;
		this.workStartDate = workStartDate;
		this.consortiumAgreementNumber = consortiumAgreementNumber;
		this.ECTSCreditStudy = ECTSCreditStudy;
		this.ECTSCreditWork = ECTSCreditWork;
		this.totalCredits = totalCredits;
		this.sevSupplement = sevSupplement;
		this.taughtHostLang = taughtHostLang;
		this.languageTaught = languageTaught;
		this.lingPreparation = lingPreparation;
		this.studyGrant = studyGrant;
		this.workGrant = workGrant;
		this.previousPartecipation = previousPartecipation;
		this.qualificationHost = qualificationHost;
	}
	
	
	@Override
	public String toString() 
	{
		return "MetaData [homeInstitution=" + homeInstitution + ", countryHome=" + countryHome + ", age=" + age
				+ ", sex=" + sex + ", nationality=" + nationality + ", subjectArea=" + subjectArea + ", levelStudy="
				+ levelStudy + ", yearsPrior=" + yearsPrior + ", mobility=" + mobility + ", hostInstitution="
				+ hostInstitution + ", countryHost=" + countryHost + ", workPlacement=" + workPlacement + ", countryWP="
				+ countryWP + ", enterpriseSize=" + enterpriseSize + ", typeWorkSector=" + typeWorkSector
				+ ", studyLenght=" + studyLenght + ", workLenght=" + workLenght + ", shortDuration=" + shortDuration
				+ ", studyStartDate=" + studyStartDate + ", workStartDate=" + workStartDate
				+ ", consortiumAgreementNumber=" + consortiumAgreementNumber + ", ECTSCreditStudy=" + ECTSCreditStudy
				+ ", ECTSCreditWork=" + ECTSCreditWork + ", totalCredits=" + totalCredits + ", sevSupplement="
				+ sevSupplement + ", taughtHostLang=" + taughtHostLang + ", languageTaught=" + languageTaught
				+ ", lingPreparation=" + lingPreparation + ", studyGrant=" + studyGrant + ", workGrant=" + workGrant
				+ ", previousPartecipation=" + previousPartecipation + ", qualificationHost=" + qualificationHost + "]";
	}


	public String getHomeInstitution() {
		return homeInstitution;
	}
	public String getCountryHome() {
		return countryHome;
	}
	public int getAge() {
		return age;
	}
	public char getSex() {
		return sex;
	}
	public String getNationality() {
		return nationality;
	}
	public int getSubjectArea() {
		return subjectArea;
	}
	public String getLevelStudy() {
		return levelStudy;
	}
	public int getYearsPrior() {
		return yearsPrior;
	}
	public char getMobility() {
		return mobility;
	}
	public String getHostInstitution() {
		return hostInstitution;
	}
	public String getCountryHost() {
		return countryHost;
	}
	public String getWorkPlacement() {
		return workPlacement;
	}
	public String getCountryWP() {
		return countryWP;
	}
	public char getEnterpriseSize() {
		return enterpriseSize;
	}
	public char getTypeWorkSector() {
		return typeWorkSector;
	}
	public double getStudyLenght() {
		return studyLenght;
	}
	public double getWorkLenght() {
		return workLenght;
	}
	public char getShortDuration() {
		return shortDuration;
	}
	public String getStudyStartDate() {
		return studyStartDate;
	}
	public String getWorkStartDate() {
		return workStartDate;
	}
	public String getConsortiumAgreementNumber() {
		return consortiumAgreementNumber;
	}
	public int getECTSCreditStudy() {
		return ECTSCreditStudy;
	}
	public int getECTSCreditWork() {
		return ECTSCreditWork;
	}
	public int getTotalCredits() {
		return totalCredits;
	}
	public double getSevSupplement() {
		return sevSupplement;
	}
	public char getTaughtHostLang() {
		return taughtHostLang;
	}
	public String getLanguageTaught() {
		return languageTaught;
	}
	public String getLingPreparation() {
		return lingPreparation;
	}
	public double getStudyGrant() {
		return studyGrant;
	}
	public double getWorkGrant() {
		return workGrant;
	}
	public char getPreviousPartecipation() {
		return previousPartecipation;
	}
	public String getQualificationHost() {
		return qualificationHost;
	}
		
	
}
