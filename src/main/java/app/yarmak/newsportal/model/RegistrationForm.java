package app.yarmak.newsportal.model;

import java.time.LocalDate;
import java.util.List;

public class RegistrationForm {
	 private String username;
	    private String email;
	    private String password;
	    private LocalDate birthDate;
	    private String gender; // Radio buttons
	    private String country; // Dropdown (select)
	    private List<String> hobbies; // Checkbox values

	    // Геттеры и сеттеры
	    public String getUsername() { return username; }
	    public void setUsername(String username) { this.username = username; }

	    public String getEmail() { return email; }
	    public void setEmail(String email) { this.email = email; }

	    public String getPassword() { return password; }
	    public void setPassword(String password) { this.password = password; }

	    public LocalDate getBirthDate() { return birthDate; }
	    public void setBirthDate(LocalDate birthDate) { this.birthDate = birthDate; }

	    public String getGender() { return gender; }
	    public void setGender(String gender) { this.gender = gender; }

	    public String getCountry() { return country; }
	    public void setCountry(String country) { this.country = country; }

	    public List<String> getHobbies() { return hobbies; }
	    public void setHobbies(List<String> hobbies) { this.hobbies = hobbies; }
}
