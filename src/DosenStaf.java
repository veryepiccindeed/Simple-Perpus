public class DosenStaf {
    private int NIK;
    private String password;
    private String nama;
    private String fakultas;
    private String alamat;
    private String noHp;
    private String status;

    public DosenStaf () {}

    public DosenStaf(int NIK, String password, String nama, String fakultas, String alamat, String noHp, String status) {
        this.NIK = NIK;
        this.password = password;
        this.nama = nama;
        this.fakultas = fakultas;
        this.alamat = alamat;
        this.noHp = noHp;
        this.status = status;
    }

    // Getter dan Setter
    public int getNIK() {
        return NIK;
    }

    public void setNIK(int NIK) {
        this.NIK = NIK;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getFakultas() {
        return fakultas;
    }

    public void setFakultas(String fakultas) {
        this.fakultas = fakultas;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
