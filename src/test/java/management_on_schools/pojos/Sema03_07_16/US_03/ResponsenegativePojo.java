package management_on_schools.pojos.Sema03_07_16.US_03;

import java.io.Serializable;

public class ResponsenegativePojo implements Serializable {
	private String message;
	private int statusCode;
	private String path;

	public ResponsenegativePojo() {
	}

	public ResponsenegativePojo(String message, int statusCode, String path, long timeStamp, ValidationsnegativePojo validations) {
		this.message = message;
		this.statusCode = statusCode;
		this.path = path;
		this.timeStamp = timeStamp;
		this.validations = validations;
	}

	private long timeStamp;
	private ValidationsnegativePojo validations;

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

	public void setValidations(ValidationsnegativePojo validations){
		this.validations = validations;
	}

	public ValidationsnegativePojo getValidations(){
		return validations;
	}

	@Override
 	public String toString(){
		return 
			"ResponsenegativePojo{" + 
			"message = '" + message + '\'' + 
			",statusCode = '" + statusCode + '\'' + 
			",path = '" + path + '\'' + 
			",timeStamp = '" + timeStamp + '\'' + 
			",validations = '" + validations + '\'' + 
			"}";
		}
}