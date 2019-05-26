import java.util.ArrayList;

public class User {
    private String username;
    private String password;
    private String school;
    private String major;
    private boolean LOGIN=false;
    private ArrayList<Question> Asked;
    private ArrayList<Question> Solved;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLOGIN(){
        LOGIN = true;
    }

    public String getMajor(){
        return major;
    }

    public String getSchool(){
        return school;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setSchool(String school) {
        this.school = school;
    }
}