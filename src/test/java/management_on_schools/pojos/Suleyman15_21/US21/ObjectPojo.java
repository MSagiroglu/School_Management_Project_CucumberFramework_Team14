package management_on_schools.pojos.Suleyman15_21.US21;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ObjectPojo implements Serializable {
    private int userId;
    private String username;
    private String name;
    private String surname;
    private String birthDay;
    private String birthPlace;
    private String phoneNumber;
    private String gender;
    private int studentNumber;
    private String motherName;
    private String fatherName;
    private String email;
    private boolean active;

    public ObjectPojo() {
    }

    public ObjectPojo(int userId, String username, String name, String surname, String birthDay, String birthPlace, String phoneNumber, String gender, int studentNumber, String motherName, String fatherName, String email, boolean active) {
        this.userId = userId;
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.birthDay = birthDay;
        this.birthPlace = birthPlace;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.studentNumber = studentNumber;
        this.motherName = motherName;
        this.fatherName = fatherName;
        this.email = email;
        this.active = active;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isActive() {
        return active;
    }

    @Override
    public String toString() {
        return
                "ObjectPojo{" +
                        "userId = '" + userId + '\'' +
                        ",username = '" + username + '\'' +
                        ",name = '" + name + '\'' +
                        ",surname = '" + surname + '\'' +
                        ",birthDay = '" + birthDay + '\'' +
                        ",birthPlace = '" + birthPlace + '\'' +
                        ",phoneNumber = '" + phoneNumber + '\'' +
                        ",gender = '" + gender + '\'' +
                        ",studentNumber = '" + studentNumber + '\'' +
                        ",motherName = '" + motherName + '\'' +
                        ",fatherName = '" + fatherName + '\'' +
                        ",email = '" + email + '\'' +
                        ",active = '" + active + '\'' +
                        "}";
    }
}