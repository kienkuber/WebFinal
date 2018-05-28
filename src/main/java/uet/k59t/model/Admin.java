package uet.k59t.model;

public class Admin {
    private static String token;
    private static final Role role = Role.ADMIN;

    public static String getToken() {
        return token;
    }

    public static void setToken(String token) {
        Admin.token = token;
    }

    public static Role getRole() {
        return role;
    }
}

