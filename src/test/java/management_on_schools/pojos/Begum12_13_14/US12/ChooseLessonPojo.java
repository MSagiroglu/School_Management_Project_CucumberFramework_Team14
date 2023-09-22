package management_on_schools.pojos.Begum12_13_14.US12;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.io.Serializable;
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChooseLessonPojo implements Serializable {
	private List<Integer> lessonProgramId;
	private int teacherId;

	public ChooseLessonPojo() {
	}

	public ChooseLessonPojo(List<Integer> lessonProgramId, int teacherId) {
		this.lessonProgramId = lessonProgramId;
		this.teacherId = teacherId;
	}



	public void setLessonProgramId(List<Integer> lessonProgramId){
		this.lessonProgramId = lessonProgramId;
	}

	public List<Integer> getLessonProgramId(){
		return lessonProgramId;
	}

	public void setTeacherId(int teacherId){
		this.teacherId = teacherId;
	}

	public int getTeacherId(){
		return teacherId;
	}

	@Override
 	public String toString(){
		return 
			"ChooseLessonPojoDTO{" + 
			"lessonProgramId = '" + lessonProgramId + '\'' + 
			",teacherId = '" + teacherId + '\'' + 
			"}";
		}
}