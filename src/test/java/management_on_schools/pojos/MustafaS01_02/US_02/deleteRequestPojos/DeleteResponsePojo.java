package management_on_schools.pojos.MustafaS01_02.US_02.deleteRequestPojos;

import java.io.Serializable;

public class DeleteResponsePojo implements Serializable {
	public DeleteResponsePojo() {
	}

	public DeleteResponsePojo(String message, String httpStatus) {
		this.message = message;
		this.httpStatus = httpStatus;
	}

	private String message;
	private String httpStatus;

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
			"DeleteResponsePojo{" + 
			"message = '" + message + '\'' + 
			",httpStatus = '" + httpStatus + '\'' + 
			"}";
		}
}