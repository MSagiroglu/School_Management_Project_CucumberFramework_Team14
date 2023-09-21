package management_on_schools.pojos.Yekta_US24_25.US25.NegativeScenarios;

import java.io.Serializable;

public class US25NegativeResponsePojo implements Serializable {
	private String message;
	private int statusCode;
	private String path;
	private long timeStamp;
	private US25ValidationsPojo validations;

	public US25NegativeResponsePojo() {
	}

	public US25NegativeResponsePojo(String message, int statusCode, String path, long timeStamp, US25ValidationsPojo validations) {
		this.message = message;
		this.statusCode = statusCode;
		this.path = path;
		this.timeStamp = timeStamp;
		this.validations = validations;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	public void setStatusCode(int statusCode){
		this.statusCode = statusCode;
	}

	public int getStatusCode(){
		return statusCode;
	}

	public void setPath(String path){
		this.path = path;
	}

	public String getPath(){
		return path;
	}

	public void setTimeStamp(long timeStamp){
		this.timeStamp = timeStamp;
	}

	public long getTimeStamp(){
		return timeStamp;
	}

	public void setValidations(US25ValidationsPojo validations){
		this.validations = validations;
	}

	public US25ValidationsPojo getValidations(){
		return validations;
	}

	@Override
 	public String toString(){
		return 
			"US25NegativeResponsePojo{" + 
			"message = '" + message + '\'' + 
			",statusCode = '" + statusCode + '\'' + 
			",path = '" + path + '\'' + 
			",timeStamp = '" + timeStamp + '\'' + 
			",validations = '" + validations + '\'' + 
			"}";
		}
}