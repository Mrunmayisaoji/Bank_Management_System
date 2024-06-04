package dev.codescreen.Model;

public class userModel {
    private long userid;
    private String firstName;
    private String lastName;
    private String password;
    
    public long getUserid() {
        return userid;
    }
    public void setUserid(long userid) {
        this.userid = userid;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public userModel(long userid, String firstName, String lastName, String password) {
        this.userid = userid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }
    @Override
    public String toString() {
        return "userModel [userid=" + userid + ", firstName=" + firstName + ", lastName=" + lastName + ", password="
                + password + "]";
    }
   
    
    
}
