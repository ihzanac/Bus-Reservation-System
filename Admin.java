public class Admin {
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "admin123";

    public static boolean login(String username, String password) {
        return USERNAME.equals(username) && PASSWORD.equals(password);
    }
}
