package model;
import java.io.Serializable;
/**
* Classe modellante dei dati che associano uno studente ad una corporazione, contiene i dati
* dello stage.	
*/

public class Internship implements Serializable
{
	private Student s;
	private Corporation c;
	private int studyLenght;
	private int workLenght;
	private boolean shortDuration;
	private String startDate;
	private int ECTSCreditStudy;
	private int ECTSCreditWork;
	private int totalCredits;
	private int sevSupplement;
	private char taughtHostLang;
	private float studyGrant;
	private float workGrant;
	private String qualificationHost;

	/**
	 * Costruttore della classe.
	 * 
	 * @param s
	 * @param c
	 * @param studyLenght
	 * @param workLenght
	 * @param shortDuration
	 * @param startDate
	 * @param ECTSCreditStudy
	 * @param ECTSCreditWork
	 * @param totalCredits
	 * @param sevSupplement 
	 * @param taughtHostLang
	 * @param studyGrant
	 * @param workGrant
	 * @param qualificationHost
	 */
	
	public Internship(Student s,Corporation c,int studyLenght,int workLenght,boolean shortDuration,String startDate,int ECTSCreditStudy,int ECTSCreditWork,int totalCredits,int sevSupplement,char taughtHostLang,float studyGrant,float workGrant,String qualification)
	{
		this.s=s;
		this.c=c;
		this.studyLenght=studyLenght;
		this.workLenght=workLenght;
		this.shortDuration=shortDuration;
		this.startDate=startDate;
		this.ECTSCreditStudy=ECTSCreditStudy;
		this.ECTSCreditWork=ECTSCreditWork;
		this.totalCredits=totalCredits;
		this.sevSupplement=sevSupplement;
		this.taughtHostLang=taughtHostLang;
		this.studyGrant=studyGrant;
		this.workGrant=workGrant;
		this.qualificationHost=qualification;	
	}
	//get
	  public Student getS() { return s;  }
	  public Corporation getC() { return c;  }
	  public int getStudyLenght() { return studyLenght;  }
	  public int getWorkLenght() { return workLenght;  }
	  public boolean getShortDuration() { return shortDuration;  }
	  public String getStartDate() { return startDate;  }
	  public int getECTSCreditStudy() { return ECTSCreditStudy;  }
	  public int getECTSCreditWork() { return ECTSCreditWork;  }
	  public int getTotalCredits() { return totalCredits;  }
	  public int getSevSupplement() { return sevSupplement;  }
	  public char getTaughtHostLang() { return taughtHostLang;  }
	  public float getStudyGrant() { return studyGrant;  }
	  public float getWorkGrant() { return workGrant ;  }
	  public String getQualification() { return qualificationHost;  }
	  
	  @Override
	    public String toString() 
	    {
	        return "Internship{" +
	                "Student=" + s +
	                ", Corporation='" + c + '\'' +
	                ", Study Lenght=" + studyLenght +
	                ", Work Lenght=" + workLenght +
	                ", Is a short duration project? =" + shortDuration +
	                ", Start Date=" + startDate +
	                ", ECTS Credit Study=" + ECTSCreditStudy +
	                ", ECTS Credit Work=" + ECTSCreditWork +
	                ", Total credits=" + totalCredits +
	                ", Sev Supplement=" + sevSupplement +
	                ", Taught Host Language=" + taughtHostLang +
	                ", Study Grant=" + studyGrant +
	                ", Placement Grant=" + workGrant +
	                ", Qualification=" + qualificationHost +
	                '}';
	    }
}
