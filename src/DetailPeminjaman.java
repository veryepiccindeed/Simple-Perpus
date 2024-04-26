public class DetailPeminjaman {
    private Peminjaman peminjaman;
    private int idKoleksi;
    private int jumlah;
    private String tanggalKembali;

    public DetailPeminjaman(Peminjaman peminjaman, int idKoleksi, int jumlah, String tanggalKembali) {
        this.peminjaman = peminjaman;
        this.idKoleksi = idKoleksi;
        this.jumlah = jumlah;
        this.tanggalKembali = tanggalKembali;
    }

    // Getter dan Setter
    public Peminjaman getPeminjaman() {
        return peminjaman;
    }

    public void setPeminjaman(Peminjaman peminjaman) {
        this.peminjaman = peminjaman;
    }

    public int getIdKoleksi() {
        return idKoleksi;
    }

    public void setIdKoleksi(int idKoleksi) {
        this.idKoleksi = idKoleksi;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public String getTanggalKembali() {
        return tanggalKembali;
    }

    public void setTanggalKembali(String tanggalKembali) {
        this.tanggalKembali = tanggalKembali;
    }
}