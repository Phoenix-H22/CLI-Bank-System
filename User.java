import java.util.Scanner;
public class User {
    protected String username;
    protected String password;
    protected boolean isAdmin;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.isAdmin = false;
    }
    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
    public boolean isAdmin() {
        return isAdmin;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
}

