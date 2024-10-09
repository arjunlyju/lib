
import java.util.ArrayList;
import java.util.List;

public class LoginController {
    private List<User> users = new ArrayList<>();

    public LoginController() {
        // Adding a default admin user
        users.add(new User("admin", "reading_admin", "Admin", "Admin", true));
    }

    public User login(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public void addUser(User user) {
        users.add(user);
    }
}
