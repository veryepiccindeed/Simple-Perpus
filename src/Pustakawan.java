public class Pustakawan {
    private int idPustakawan;
    private String namaPustakawan;
    private String alamat;
    private String noHp;
    private String jenisKelamin;
    private String email;
    private String password;

    public Pustakawan(int idPustakawan, String namaPustakawan, String alamat, String noHp, String jenisKelamin, String email, String password) {
        this.idPustakawan = idPustakawan;
        this.namaPustakawan = namaPustakawan;
        this.alamat = alamat;
        this.noHp = noHp;
        this.jenisKelamin = jenisKelamin;
        this.email = email;
        this.password = password;
    }

    // Getter dan Setter
    public int getIdPustakawan() {
        return idPustakawan;
    }

    public void setIdPustakawan(int idPustakawan) {
        this.idPustakawan = idPustakawan;
    }

    public Pustakawan(String nama) {
        this.namaPustakawan = nama;
    }


    public String getNamaPustakawan() {
        return namaPustakawan;
    }

    public void setNamaPustakawan(String namaPustakawan) {
        this.namaPustakawan = namaPustakawan;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}