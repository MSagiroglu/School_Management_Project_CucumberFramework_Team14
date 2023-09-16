package management_on_schools.pojos.MustafaS01_02.US_01.negative_post_response;

import java.io.Serializable;

public class NegativePostResponsePojo implements Serializable {
	private String message;
	private int statusCode;
	private String path;
	private long timeStamp;
	private ValidationsPojo validations;

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

	public void setValidations(ValidationsPojo validations){
		this.validations = validations;
	}

	public ValidationsPojo getValidations(){
		return validations;
	}

	@Override
 	public String toString(){
		return 
			"NegativePostResponsePojo{" + 
			"message = '" + message + '\'' + 
			",statusCode = '" + statusCode + '\'' + 
			",path = '" + path + '\'' + 
			",timeStamp = '" + timeStamp + '\'' + 
			",validations = '" + validations + '\'' + 
			"}";
		}
}