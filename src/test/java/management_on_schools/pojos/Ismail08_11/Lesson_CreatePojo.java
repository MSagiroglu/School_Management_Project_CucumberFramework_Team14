package management_on_schools.pojos.Ismail08_11;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class Lesson_CreatePojo {
    private boolean compulsory;
    private String creditScore;
    private String lessonName;

    public Lesson_CreatePojo() {
    }

    public boolean isCompulsory() {
        return compulsory;
    }

    public void setCompulsory(boolean compulsory) {
        this.compulsory = compulsory;
    }

    public String getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(String creditScore) {
        this.creditScore = creditScore;
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    @Override
    public String toString() {
        return "Lesson_CreatePojo{" +
                "compulsory=" + compulsory +
                ", creditScore='" + creditScore + '\'' +
                ", lessonName='" + lessonName + '\'' +
                '}';
    }

    public Lesson_CreatePojo(boolean compulsory, String creditScore, String lessonName) {
        this.compulsory = compulsory;
        this.creditScore = creditScore;
        this.lessonName = lessonName;
    }
}
