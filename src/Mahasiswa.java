public class Mahasiswa {
    private int NIM;
    private String password;
    private String nama;
    private String fakultas;
    private String alamat;
    private String noHp;
    private String status;

    public Mahasiswa() {}

    public Mahasiswa(int NIM, String password, String nama, String fakultas, String alamat, String noHp, String status) {
        this.NIM = NIM;
        this.password = password;
        this.nama = nama;
        this.fakultas = fakultas;
        this.alamat = alamat;
        this.noHp = noHp;
        this.status = status;
    }

    // Getter dan Setter
    public int getNIM() {
        return NIM;
    }

    public void setNIM(int NIM) {
        this.NIM = NIM;
    }

    public String getPassword () {
        return password;
    }

    public void setPassword (String password) {
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