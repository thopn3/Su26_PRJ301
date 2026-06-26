
package Models;

import java.sql.Date;

public class User {
    private int id;
    private String email;
    private String password;
    private String fullname;
    private String gender;
    private Date dob;
    private String phone;
    private String role;

    public User(String email, String password, String fullname, String gender, Date dob, String phone, String role) {
        this.email = email;
        this.password = password;
        this.fullname = fullname;
        this.gender = gender;
        this.dob = dob;
        this.phone = phone;
        this.role = role;
    }

    
    public User() {
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getGender() {
        return gender;
    }

    public Date getDob() {
        return dob;
    }

    public String getPhone() {
        return phone;
    }
    
    
}
