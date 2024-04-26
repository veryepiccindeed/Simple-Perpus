public class PustakawanRepository {
    private static final PustakawanData[] PUSTAKAWANS = {
        new PustakawanData("admin", "123"),
        new PustakawanData("pustakawan1", "123"),
        new PustakawanData("pustakawan2", "123")
    };
    
    public static boolean isValidLogin(String inputUsername, String inputPassword) {
        for (PustakawanData data : PUSTAKAWANS) {
            if (data.getUsername().equals(inputUsername) && bcryptCheck(inputPassword, data.getPassword())) {
                return true;
            }
        }
        return false;
    }

    private static boolean bcryptCheck(String inputPassword, String hashedPassword) {
        // Implementasi bcrypt untuk memeriksa password
        // Misalnya dengan menggunakan library BCrypt
        // return BCrypt.checkpw(inputPassword, hashedPassword);
        return inputPassword.equals(hashedPassword); // Hanya contoh, sebaiknya gunakan bcrypt asli
    }
}

class PustakawanData {
    private String username;
    private String password;

    public PustakawanData(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getter
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
