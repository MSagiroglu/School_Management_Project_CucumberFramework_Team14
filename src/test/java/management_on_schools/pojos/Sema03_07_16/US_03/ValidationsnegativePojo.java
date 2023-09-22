package management_on_schools.pojos.Sema03_07_16.US_03;

import java.io.Serializable;

public class ValidationsnegativePojo implements Serializable {
	private String name;

	public ValidationsnegativePojo() {
	}

	public ValidationsnegativePojo(String name) {
		this.name = name;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	@Override
 	public String toString(){
		return 
			"ValidationsnegativePojo{" + 
			"name = '" + name + '\'' + 
			"}";
		}
}