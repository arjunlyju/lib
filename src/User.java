
public class User {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private boolean isAdmin;

    public User(String username, String password, String firstName, String lastName, boolean isAdmin) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isAdmin = isAdmin;
    }

    // Getters and Setters for user details
    public String getUsername() { return username; }
    public void setPassword(String password) { this.password = password; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public boolean isAdmin() { return isAdmin; }
}
