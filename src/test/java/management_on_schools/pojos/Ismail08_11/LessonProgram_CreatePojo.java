package management_on_schools.pojos.Ismail08_11;

import java.util.List;

public class LessonProgram_CreatePojo {
//    {
//        "day": "SUNDAY",
//            "educationTermId": 1,
//            "lessonIdList": [
//        1250
//  ],
//        "startTime": "13:00",
//            "stopTime": "14:00"
//    }

    private String day;
    private String educationTermId;
    private List<String> lessonIdList;
    private String startTime;
    private String stopTime;

    public LessonProgram_CreatePojo(String day, String educationTermId, List<String> lessonIdList, String startTime, String stopTime) {
        this.day = day;
        this.educationTermId = educationTermId;
        this.lessonIdList = lessonIdList;
        this.startTime = startTime;
        this.stopTime = stopTime;
    }

    public LessonProgram_CreatePojo() {
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getEducationTermId() {
        return educationTermId;
    }

    public void setEducationTermId(String educationTermId) {
        this.educationTermId = educationTermId;
    }

    public List<String> getLessonIdList() {
        return lessonIdList;
    }

    public void setLessonIdList(List<String> lessonIdList) {
        this.lessonIdList = lessonIdList;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getStopTime() {
        return stopTime;
    }

    public void setStopTime(String stopTime) {
        this.stopTime = stopTime;
    }

    @Override
    public String toString() {
        return "LessonProgram_CreatePojo{" +
                "day='" + day + '\'' +
                ", educationTermId='" + educationTermId + '\'' +
                ", lessonIdList=" + lessonIdList +
                ", startTime='" + startTime + '\'' +
                ", stopTime='" + stopTime + '\'' +
                '}';
    }
}
