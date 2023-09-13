package management_on_schools.pojos.MustafaS01_02.US_02;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
@JsonIgnoreProperties(ignoreUnknown = true)
public class ContentPojo implements Serializable {
	public ContentPojo() {
	}

	public ContentPojo( String username, String ssn, String name, String surname, String birthDay, String birthPlace, String phoneNumber, String gender) {
		this.username = username;
		this.ssn = ssn;
		this.name = name;
		this.surname = surname;
		this.birthDay = birthDay;
		this.birthPlace = birthPlace;
		this.phoneNumber = phoneNumber;
		this.gender = gender;
	}

	private int id;
	private String username;
	private String ssn;
	private String name;
	private String surname;
	private String birthDay;
	private String birthPlace;
	private String phoneNumber;
	private String gender;

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return username;
	}

	public void setSsn(String ssn){
		this.ssn = ssn;
	}

	public String getSsn(){
		return ssn;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setSurname(String surname){
		this.surname = surname;
	}

	public String getSurname(){
		return surname;
	}

	public void setBirthDay(String birthDay){
		this.birthDay = birthDay;
	}

	public String getBirthDay(){
		return birthDay;
	}

	public void setBirthPlace(String birthPlace){
		this.birthPlace = birthPlace;
	}

	public String getBirthPlace(){
		return birthPlace;
	}

	public void setPhoneNumber(String phoneNumber){
		this.phoneNumber = phoneNumber;
	}

	public String getPhoneNumber(){
		return phoneNumber;
	}

	public void setGender(String gender){
		this.gender = gender;
	}

	public String getGender(){
		return gender;
	}

	@Override
 	public String toString(){
		return 
			"ContentPojo{" + 
			"id = '" + id + '\'' + 
			",username = '" + username + '\'' + 
			",ssn = '" + ssn + '\'' + 
			",name = '" + name + '\'' + 
			",surname = '" + surname + '\'' + 
			",birthDay = '" + birthDay + '\'' + 
			",birthPlace = '" + birthPlace + '\'' + 
			",phoneNumber = '" + phoneNumber + '\'' + 
			",gender = '" + gender + '\'' + 
			"}";
		}
}