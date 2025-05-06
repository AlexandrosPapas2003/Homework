package loginAsAdmin;

public class Admin {
    private static final String USERNAME = "Admin";
    private static final String PASSWORD = "admin123";

    public static String getPASSWORD() {
        return PASSWORD;
    }

    private Admin() {
    }

    public static String getUSERNAME() {
        return USERNAME;
    }
}
