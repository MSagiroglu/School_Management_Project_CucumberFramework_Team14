package management_on_schools.pojos.Yekta_US24_25.US24.NegativeScenarios;

import java.io.Serializable;

public class US24ValidationsPojo implements Serializable {
	private String lessonsIdList;

	public US24ValidationsPojo() {
	}

	public US24ValidationsPojo(String lessonsIdList) {
		this.lessonsIdList = lessonsIdList;
	}

	public void setLessonsIdList(String lessonsIdList){
		this.lessonsIdList = lessonsIdList;
	}

	public String getLessonsIdList(){
		return lessonsIdList;
	}

	@Override
 	public String toString(){
		return 
			"US24ValidationsPojo{" +
			"lessonsIdList = '" + lessonsIdList + '\'' + 
			"}";
		}
}