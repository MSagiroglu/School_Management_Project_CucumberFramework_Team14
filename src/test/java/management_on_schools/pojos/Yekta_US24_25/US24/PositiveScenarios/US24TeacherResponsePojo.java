package management_on_schools.pojos.Yekta_US24_25.US24.PositiveScenarios;

import management_on_schools.pojos.Yekta_US24_25.US24.PositiveScenarios.US24ObjectPojo;

import java.io.Serializable;

public class US24TeacherResponsePojo implements Serializable {
	private US24ObjectPojo object;
	private String message;
	private String httpStatus;

	public US24TeacherResponsePojo() {
	}

	public US24TeacherResponsePojo(US24ObjectPojo object, String message, String httpStatus) {
		this.object = object;
		this.message = message;
		this.httpStatus = httpStatus;
	}

	public void setObject(US24ObjectPojo object){
		this.object = object;
	}

	public US24ObjectPojo getObject(){
		return object;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	public void setHttpStatus(String httpStatus){
		this.httpStatus = httpStatus;
	}

	public String getHttpStatus(){
		return httpStatus;
	}

	@Override
 	public String toString(){
		return 
			"US24TeacherResponsePojo{" + 
			"object = '" + object + '\'' + 
			",message = '" + message + '\'' + 
			",httpStatus = '" + httpStatus + '\'' + 
			"}";
		}
}