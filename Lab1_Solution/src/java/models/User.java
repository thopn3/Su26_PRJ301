
package models;

public class User {
    private String email;
    private String password;
    private String dob;
    private String gender;
    private String city;

    public User(String email, String password, String dob, String gender, String city) {
        this.email = email;
        this.password = password;
        this.dob = dob;
        this.gender = gender;
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getDob() {
        return dob;
    }

    public String getGender() {
        return gender;
    }

    public String getCity() {
        return city;
    }
}
