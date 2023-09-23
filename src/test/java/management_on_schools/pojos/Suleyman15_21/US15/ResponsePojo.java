package management_on_schools.pojos.Suleyman15_21.US15;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponsePojo implements Serializable {
    private ObjectPojo object;
    private String message;
    public ResponsePojo() {
    }

    public ResponsePojo(ObjectPojo object, String message) {
        this.object = object;
        this.message = message;
    }

    public void setObject(ObjectPojo object) {
        this.object = object;
    }

    public ObjectPojo getObject() {
        return object;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return
                "ResponsePojo{" +
                        "object = '" + object + '\'' +
                        ",message = '" + message + '\'' +
                        "}";
    }
}