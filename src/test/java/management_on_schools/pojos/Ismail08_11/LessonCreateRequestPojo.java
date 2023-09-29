package management_on_schools.pojos.Ismail08_11;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString

public class LessonCreateRequestPojo {




    private Boolean compulsory;
    private int creditScore;
    private String lessonName;

}
