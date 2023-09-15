package management_on_schools.pojos.MustafaS01_02.US_01.meet;

import java.util.List;
import java.io.Serializable;

public class PostDTO implements Serializable {
	private String date;
	private String description;
	private String startTime;
	private String stopTime;
	private List<String> studentIds;

	public void setDate(String date){
		this.date = date;
	}

	public String getDate(){
		return date;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setStartTime(String startTime){
		this.startTime = startTime;
	}

	public String getStartTime(){
		return startTime;
	}

	public void setStopTime(String stopTime){
		this.stopTime = stopTime;
	}

	public String getStopTime(){
		return stopTime;
	}

	public void setStudentIds(List<String> studentIds){
		this.studentIds = studentIds;
	}

	public List<String> getStudentIds(){
		return studentIds;
	}

	@Override
 	public String toString(){
		return 
			"PostDTO{" + 
			"date = '" + date + '\'' + 
			",description = '" + description + '\'' + 
			",startTime = '" + startTime + '\'' + 
			",stopTime = '" + stopTime + '\'' + 
			",studentIds = '" + studentIds + '\'' + 
			"}";
		}
}