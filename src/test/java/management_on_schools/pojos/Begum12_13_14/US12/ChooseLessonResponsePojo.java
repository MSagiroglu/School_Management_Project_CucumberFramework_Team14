package management_on_schools.pojos.Begum12_13_14.US12;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ChooseLessonResponsePojo {
    private String message;

    public ChooseLessonResponsePojo() {
    }

    public ChooseLessonResponsePojo(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ChooseLessonResponsePojo{" +
                "message='" + message + '\'' +
                '}';
    }
}
