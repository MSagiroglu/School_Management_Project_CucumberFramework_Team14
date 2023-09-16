package management_on_schools.pojos.Ismail08_11;




import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Response_LessonCreat_Pojo {



    private Lesson_CreatePojo object;

    private String message;

    public Response_LessonCreat_Pojo() {
    }

    public Lesson_CreatePojo getObject() {
        return object;
    }

    public void setObject(Lesson_CreatePojo object) {
        this.object = object;
    }

    @Override
    public String toString() {
        return "Response_LessonCreat_Pojo{" +
                "object=" + object +
                ", message='" + message + '\'' +
                '}';
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Response_LessonCreat_Pojo(Lesson_CreatePojo object, String message) {
        this.object = object;
        this.message = message;
    }
}
