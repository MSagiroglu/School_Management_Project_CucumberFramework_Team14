package management_on_schools.pojos.Yekta_US24_25.US24;

import java.io.Serializable;

public class US24NegativeResponsePojo implements Serializable {
	private String message;
	private int statusCode;
	private String path;
	private long timeStamp;
	private US24ValidationsPojo validations;

	public US24NegativeResponsePojo() {
	}

	public US24NegativeResponsePojo(String message, int statusCode, String path, long timeStamp, US24ValidationsPojo validations) {
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

	public void setValidations(US24ValidationsPojo validations){
		this.validations = validations;
	}

	public US24ValidationsPojo getValidations(){
		return validations;
	}

	@Override
 	public String toString(){
		return 
			"US24NegativeResponsePojo{" + 
			"message = '" + message + '\'' + 
			",statusCode = '" + statusCode + '\'' + 
			",path = '" + path + '\'' + 
			",timeStamp = '" + timeStamp + '\'' + 
			",validations = '" + validations + '\'' + 
			"}";
		}
}