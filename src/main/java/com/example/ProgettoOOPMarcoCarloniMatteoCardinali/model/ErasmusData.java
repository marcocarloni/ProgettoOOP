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
	private String subjectArea;
	private String levelStudy;
	private int yearsPrior;
	private char mobilityType;
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
	private boolean taughtHostLang;
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
	 * @param mobilityType
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
	
	public ErasmusData(String homeInstitution, String countryHome, int age, char sex, String nationality, String subjectArea,
			String levelStudy, int yearsPrior, char mobilityType, String hostInstitution, String countryHost,
			String workPlacement, String countryWP, char enterpriseSize, char typeWorkSector, double studyLenght,
			double workLenght, char shortDuration, String studyStartDate, String workStartDate,
			String consortiumAgreementNumber, int ECTSCreditStudy, int ECTSCreditWork, int totalCredits, double sevSupplement,
			boolean taughtHostLang, String languageTaught, String lingPreparation, double studyGrant, double workGrant,
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
		this.mobilityType = mobilityType;
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
				+ levelStudy + ", yearsPrior=" + yearsPrior + ", mobilityType=" + mobilityType + ", hostInstitution="
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

	public void setHomeInstitution(String homeInstitution) {
		this.homeInstitution = homeInstitution;
	}

	public String getCountryHome() {
		return countryHome;
	}

	public void setCountryHome(String countryHome) {
		this.countryHome = countryHome;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public char getSex() {
		return sex;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getSubjectArea() {
		return subjectArea;
	}

	public void setSubjectArea(String subjectArea) {
		this.subjectArea = subjectArea;
	}


	public String getLevelStudy() {
		return levelStudy;
	}

	public void setLevelStudy(String levelStudy) {
		this.levelStudy = levelStudy;
	}

	public int getYearsPrior() {
		return yearsPrior;
	}

	public void setYearsPrior(int yearsPrior) {
		this.yearsPrior = yearsPrior;
	}

	public char getMobilityType() {
		return mobilityType;
	}

	public void setMobilityType(char mobilityType) {
		this.mobilityType = mobilityType;
	}

	public String getHostInstitution() {
		return hostInstitution;
	}

	public void setHostInstitution(String hostInstitution) {
		this.hostInstitution = hostInstitution;
	}

	public String getCountryHost() {
		return countryHost;
	}

	public void setCountryHost(String countryHost) {
		this.countryHost = countryHost;
	}

	public String getWorkPlacement() {
		return workPlacement;
	}

	public void setWorkPlacement(String workPlacement) {
		this.workPlacement = workPlacement;
	}

	public String getCountryWP() {
		return countryWP;
	}

	public void setCountryWP(String countryWP) {
		this.countryWP = countryWP;
	}

	public char getEnterpriseSize() {
		return enterpriseSize;
	}

	public void setEnterpriseSize(char enterpriseSize) {
		this.enterpriseSize = enterpriseSize;
	}

	public char getTypeWorkSector() {
		return typeWorkSector;
	}

	public void setTypeWorkSector(char typeWorkSector) {
		this.typeWorkSector = typeWorkSector;
	}

	public double getStudyLenght() {
		return studyLenght;
	}

	public void setStudyLenght(double studyLenght) {
		this.studyLenght = studyLenght;
	}

	public double getWorkLenght() {
		return workLenght;
	}

	public void setWorkLenght(double workLenght) {
		this.workLenght = workLenght;
	}

	public char getShortDuration() {
		return shortDuration;
	}

	public void setShortDuration(char shortDuration) {
		this.shortDuration = shortDuration;
	}

	public String getStudyStartDate() {
		return studyStartDate;
	}

	public void setStudyStartDate(String studyStartDate) {
		this.studyStartDate = studyStartDate;
	}

	public String getWorkStartDate() {
		return workStartDate;
	}

	public void setWorkStartDate(String workStartDate) {
		this.workStartDate = workStartDate;
	}

	public String getConsortiumAgreementNumber() {
		return consortiumAgreementNumber;
	}

	public void setConsortiumAgreementNumber(String consortiumAgreementNumber) {
		this.consortiumAgreementNumber = consortiumAgreementNumber;
	}

	public int getECTSCreditStudy() {
		return ECTSCreditStudy;
	}

	public void setECTSCreditStudy(int eCTSCreditStudy) {
		ECTSCreditStudy = eCTSCreditStudy;
	}

	public int getECTSCreditWork() {
		return ECTSCreditWork;
	}

	public void setECTSCreditWork(int eCTSCreditWork) {
		ECTSCreditWork = eCTSCreditWork;
	}

	public int getTotalCredits() {
		return totalCredits;
	}

	public void setTotalCredits(int totalCredits) {
		this.totalCredits = totalCredits;
	}

	public double getSevSupplement() {
		return sevSupplement;
	}

	public void setSevSupplement(double sevSupplement) {
		this.sevSupplement = sevSupplement;
	}

	public boolean getTaughtHostLang() {
		return taughtHostLang;
	}

	public void setTaughtHostLang(boolean taughtHostLang) {
		this.taughtHostLang = taughtHostLang;
	}

	public String getLanguageTaught() {
		return languageTaught;
	}

	public void setLanguageTaught(String languageTaught) {
		this.languageTaught = languageTaught;
	}

	public String getLingPreparation() {
		return lingPreparation;
	}

	public void setLingPreparation(String lingPreparation) {
		this.lingPreparation = lingPreparation;
	}

	public double getStudyGrant() {
		return studyGrant;
	}

	public void setStudyGrant(double studyGrant) {
		this.studyGrant = studyGrant;
	}

	public double getWorkGrant() {
		return workGrant;
	}

	public void setWorkGrant(double workGrant) {
		this.workGrant = workGrant;
	}

	public char getPreviousPartecipation() {
		return previousPartecipation;
	}

	public void setPreviousPartecipation(char previousPartecipation) {
		this.previousPartecipation = previousPartecipation;
	}

	public String getQualificationHost() {
		return qualificationHost;
	}

	public void setQualificationHost(String qualificationHost) {
		this.qualificationHost = qualificationHost;
	}
	
}
