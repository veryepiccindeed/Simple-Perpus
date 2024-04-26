public class Pengembalian {
    private int idPengembalian;
    private int idPeminjaman;
    private String pustakawan;
    private String tanggalKembali;
    private int jumlahPengembalian;

    public Pengembalian(){}

    public Pengembalian(int idPengembalian, int idPeminjaman, String pustakawan, String tanggalKembali, int jumlahPengembalian) {
        this.idPengembalian = idPengembalian;
        this.idPeminjaman = idPeminjaman;
        this.pustakawan = pustakawan;
        this.tanggalKembali = tanggalKembali;
        this.jumlahPengembalian = jumlahPengembalian;
    }

    // Getter dan Setter
    public int getIdPengembalian() {
        return idPengembalian;
    }

    public void setIdPengembalian(int idPengembalian) {
        this.idPengembalian = idPengembalian;
    }

    public int getIdPeminjaman() {
        return idPeminjaman;
    }

    public void setIdPeminjaman(int idPeminjaman) {
        this.idPeminjaman = idPeminjaman;
    }

    public String getPustakawan() {
        return pustakawan;
    }

    public void setPustakawan(String pustakawan) {
        this.pustakawan = pustakawan;
    }

    public String getTanggalKembali() {
        return tanggalKembali;
    }

    public void setTanggalKembali(String tanggalKembali) {
        this.tanggalKembali = tanggalKembali;
    }

    public int getJumlahPengembalian() {
        return jumlahPengembalian;
    }

    public void setJumlahPengembalian(int jumlahPengembalian) {
        this.jumlahPengembalian = jumlahPengembalian;
    }

    public String getInfo() {
        return idPengembalian + " | " + idPeminjaman + " | " + pustakawan + " | " + tanggalKembali +   " | " + jumlahPengembalian; 
    }
}
