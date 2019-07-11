package model;

public class MetaData 
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
	private char shortDuration;
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
	private double studyGrant;
	private double workGrant;
	private char previousPartecipation;
	private String qualificationHost;
		
	public MetaData(){	}

			public String tostring() {
				return "MetaDati [toString()=" + super.toString() + "]";
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
			public char getShortDuration() {return shortDuration;}
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
			public double getStudyGrant() {return studyGrant;}
			public double getWorkGrant() {return workGrant;}
			public char getPreviousPartecipation() {return previousPartecipation;}
			public String getQualificationHost() {return qualificationHost;}
		
}
