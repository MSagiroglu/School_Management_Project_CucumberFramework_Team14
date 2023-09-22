package management_on_schools.pojos.MustafaS01_02.US_01.negative_post_response;

import java.io.Serializable;

public class ValidationsPojo implements Serializable {
	private String name;

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	@Override
 	public String toString(){
		return 
			"ValidationsPojo{" + 
			"name = '" + name + '\'' + 
			"}";
		}
}