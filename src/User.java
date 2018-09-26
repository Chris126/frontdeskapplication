
public class User {
    static String username;
    static int userId;
    //Private constructor to prevent access outside class
    private User(String username, int userId) {
        this.username = username;
        this.userId = userId;
    }
//    private instance variable to contain singleton instance
    private static User instance;

//    This method enforces the singleton pattern and session for the application 
//    by ensuring only one user instance is available in any given session
    public static synchronized User getInstance(String username, int id) {
        if (instance == null) {
            instance = new User(username, id);
        }
        return instance;
    }
    
    public static boolean isLoggedIn() {
        if (instance == null) {
            return false;
        } else {
            return true;
        }
    }
}
