package management_on_schools.pojos.Begum12_13_14.US13;

public class TeacherResponsePojo {
    private TeacherResponseObjectPojo object;
    private String httpStatus;
    private String message;

    public TeacherResponsePojo() {
    }

    public TeacherResponsePojo(TeacherResponseObjectPojo object, String httpStatus, String message) {
        this.object = object;
        this.httpStatus = httpStatus;
        this.message = message;
    }

    public TeacherResponseObjectPojo getObject() {
        return object;
    }

    public String getHttpStatus() {
        return httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setObject(TeacherResponseObjectPojo object) {
        this.object = object;
    }

    public void setHttpStatus(String httpStatus) {
        this.httpStatus = httpStatus;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "TeacherResponsePojo{" +
                "object=" + object +
                ", httpStatus='" + httpStatus + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
