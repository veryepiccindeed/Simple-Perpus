public class Peminjaman {
    private int idPeminjaman;
    private int idKlien;
    private String pustakawan;
    private String tanggalPinjam;

    public Peminjaman(){}

    public Peminjaman(int idPeminjaman, int idKlien, String pustakawan, String tanggalPinjam) {
        this.idPeminjaman = idPeminjaman;
        this.idKlien = idKlien;
        this.pustakawan = pustakawan;
        this.tanggalPinjam = tanggalPinjam;
    }

    // Getter dan Setter
    public int getIdPeminjaman() {
        return idPeminjaman;
    }

    public void setIdPeminjaman(int idPeminjaman) {
        this.idPeminjaman = idPeminjaman;
    }

    public int getIdKlien() {
        return idKlien;
    }

    public void setIdKlien(int idKlien) {
        this.idKlien = idKlien;
    }

    public String getPustakawan() {
        return pustakawan;
    }

    public void setPustakawan(String pustakawan) {
        this.pustakawan = pustakawan;
    }

    public String getTanggalPinjam() {
        return tanggalPinjam;
    }

    public void setTanggalPinjam(String tanggalPinjam) {
        this.tanggalPinjam = tanggalPinjam;
    }
}
