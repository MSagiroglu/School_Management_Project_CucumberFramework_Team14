package management_on_schools.pojos.Suleyman15_21.US21;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LessonPostPojo implements Serializable {
    private List<String> lessonProgramId;

    public LessonPostPojo() {
    }

    public LessonPostPojo(List<String> lessonProgramId) {
        this.lessonProgramId = lessonProgramId;
    }

    public void setLessonProgramId(List<String> lessonProgramId) {
        this.lessonProgramId = lessonProgramId;
    }

    public List<String> getLessonProgramId() {
        return lessonProgramId;
    }

    @Override
    public String toString() {
        return
                "LessonPostPojo{" +
                        "lessonProgramId = '" + lessonProgramId + '\'' +
                        "}";
    }
}