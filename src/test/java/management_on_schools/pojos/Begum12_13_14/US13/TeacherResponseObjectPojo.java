package management_on_schools.pojos.Begum12_13_14.US13;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TeacherResponseObjectPojo {
    private int userId;
    private String username;
    private String name;
    private String surname;
    private String birthDay;
    private String ssn;
    private String birthPlace;
    private String phoneNumber;
    private String gender;
    private String email;

    private boolean advisorTeacher;


    public TeacherResponseObjectPojo() {
    }

    public TeacherResponseObjectPojo(int userId, String username, String name, String surname, String birthDay, String ssn, String birthPlace, String phoneNumber, String gender, String email,boolean advisorTeacher) {
        this.userId = userId;
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.birthDay = birthDay;
        this.ssn = ssn;
        this.birthPlace = birthPlace;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.email = email;
        this.advisorTeacher = advisorTeacher;
    }

    public void setAdvisorTeacher(boolean advisorTeacher) {
        this.advisorTeacher = advisorTeacher;
    }

    public boolean isAdvisorTeacher() {
        return advisorTeacher;
    }

    public int getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public String getSsn() {
        return ssn;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "TeacherResponseObjectPojo{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDay='" + birthDay + '\'' +
                ", ssn='" + ssn + '\'' +
                ", birthPlace='" + birthPlace + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", advisorTeacher=" + advisorTeacher +
                '}';
    }
}
