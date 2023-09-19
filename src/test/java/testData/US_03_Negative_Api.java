package testData;
import java.util.HashMap;
import java.util.Map;

public class US_03_Negative_Api {
    public Map<String, Object> expectedDataMethod(String email, String message, String subject) {
        Map<String, Object> expectedData = new HashMap<>();
        if (email != null) {
            expectedData.put("userId", email);
        }
        if (message != null) {
            expectedData.put("title", message);
        }

        if (subject != null) {
            expectedData.put("completed", subject);
        }


        return expectedData;
    }
}
