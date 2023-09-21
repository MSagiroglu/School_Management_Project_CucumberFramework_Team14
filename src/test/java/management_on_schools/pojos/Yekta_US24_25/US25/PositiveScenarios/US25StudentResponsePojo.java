package management_on_schools.pojos.Yekta_US24_25.US25.PositiveScenarios;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import management_on_schools.pojos.Yekta_US24_25.US25.PositiveScenarios.US25ObjectPojo;

import java.io.Serializable;
@JsonIgnoreProperties(ignoreUnknown = true)
public class US25StudentResponsePojo implements Serializable {
	private US25ObjectPojo object;
	private String message;

	public US25StudentResponsePojo() {
	}

	public US25StudentResponsePojo(US25ObjectPojo object, String message) {
		this.object = object;
		this.message = message;
	}

	public void setObject(US25ObjectPojo object){
		this.object = object;
	}

	public US25ObjectPojo getObject(){
		return object;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	@Override
 	public String toString(){
		return 
			"US25StudentResponsePojo{" + 
			"object = '" + object + '\'' + 
			",message = '" + message + '\'' + 
			"}";
		}
}