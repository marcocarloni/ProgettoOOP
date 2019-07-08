package model;
import java.io.Serializable;
/**
* Classe modellante dei dati contenente gli attributi presenti nel file .csv .
* In particolare questa è la classe modellante dei dati riferiti ai vari studenti
* che hanno deciso di fare un'esperienza di studio/lavoro all'estero nel corso dell'anno 2008.	
*/
public class Student implements Serializable
{
	private int age;
	private char sex;
	private String nationality;
	private int subjectArea;
	private int levelStudy;
	private int yearsPrior;
	private char mobility;
	private	String languageTaught;
	private	String lingPreparation;
	private char previousPartecipation;
	

/**
 * Costruttore della classe.
 * 
 * @param age
 * @param sex
 * @param nationality
 * @param subjectArea
 * @param levelStudy
 * @param yearsPrior
 * @param mobility
 * @param languageTaught
 * @param lingPreparation
 * @param previousPartecipation
 */
	
	public Student(int age,char sex,String nationality,int subjectArea,int levelStudy,int yearsPrior,char mobility,String languageTaught,String lingPreparation,char previousPartecipation)
	{
		this.age=age;
		this.sex=sex;
		this.nationality=nationality;
		this.subjectArea=subjectArea;
		this.levelStudy=levelStudy;
		this.yearsPrior=yearsPrior;
		this.mobility=mobility;
		this.languageTaught =languageTaught;
		this.lingPreparation=lingPreparation;
		this.previousPartecipation=previousPartecipation;		
	}
	
	//Get
    public int getAge() { return age;  }
    public char getSex() { return sex;  }
    public String getNationality() { return nationality;  }
    public int getSubjectArea() { return subjectArea;  }
    public int getLevelStudy() { return levelStudy;  }
    public int getYearsPrior() { return yearsPrior;  }
    public char getMobility() { return mobility;  }
    public String getLanguageTaught() { return languageTaught;  }
    public String getLingPreparation() { return lingPreparation;  }
    public char getPreviousPartecipation() { return previousPartecipation;  }
    
    @Override
    public String toString() {
        return "Student{" +
                "Age=" + age +
                ", Sex='" + sex + '\'' +
                ", Nationality=" + nationality +
                ", Subject Area=" + subjectArea +
                ", Level Study=" + levelStudy +
                ", Years Prior=" + yearsPrior +
                ", Mobility=" + mobility +
                ", Language Taught=" + languageTaught +
                ", Ling Preparation=" + lingPreparation +
                ", Previous Partecipation=" + previousPartecipation +
                '}';
    }


}
