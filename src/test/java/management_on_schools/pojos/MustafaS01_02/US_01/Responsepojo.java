package management_on_schools.pojos.MustafaS01_02.US_01;

import java.io.Serializable;

public class Responsepojo implements Serializable {
	public Responsepojo() {
	}

	public Responsepojo(InnerObjectpojo object, String message, String httpStatus) {
		this.object = object;
		this.message = message;
		this.httpStatus = httpStatus;
	}

	private InnerObjectpojo object;
	private String message;
	private String httpStatus;

	public void setObject(InnerObjectpojo object){
		this.object = object;
	}

	public InnerObjectpojo getObject(){
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
			"Responsepojo{" + 
			"object = '" + object + '\'' + 
			",message = '" + message + '\'' + 
			",httpStatus = '" + httpStatus + '\'' + 
			"}";
		}
}