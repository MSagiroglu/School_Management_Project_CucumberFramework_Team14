package management_on_schools.pojos.Yekta_US24_25.US25.NegativeScenarios;

import java.io.Serializable;

public class US25ValidationsPojo implements Serializable {
	private String advisorTeacherId;

	public US25ValidationsPojo() {
	}

	public US25ValidationsPojo(String advisorTeacherId) {
		this.advisorTeacherId = advisorTeacherId;
	}

	public void setAdvisorTeacherId(String advisorTeacherId){
		this.advisorTeacherId = advisorTeacherId;
	}

	public String getAdvisorTeacherId(){
		return advisorTeacherId;
	}

	@Override
 	public String toString(){
		return 
			"US25ValidationsPojo{" +
			"advisorTeacherId = '" + advisorTeacherId + '\'' + 
			"}";
		}
}