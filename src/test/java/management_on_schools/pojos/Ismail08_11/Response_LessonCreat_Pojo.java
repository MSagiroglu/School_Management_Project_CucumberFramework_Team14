package management_on_schools.pojos.Ismail08_11;




import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class Response_LessonCreat_Pojo {

    private LessonCreateRequestPojo object;

    private String message;

}
