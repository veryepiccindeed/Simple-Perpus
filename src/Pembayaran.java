public class Pembayaran {
    private int idPeminjaman;
    private int idDenda;
    private int jumlahBukuDibayar;
    private String kategoriDenda;
    private int jumlahDenda;
    private boolean statusKerusakan;

    public Pembayaran (){}

    // Constructor
    public Pembayaran(int idPeminjaman, int idDenda, int jumlahBukuDibayar, String kategoriDenda, int jumlahDenda, boolean statusKerusakan) {
        this.idPeminjaman = idPeminjaman;
        this.idDenda = idDenda;
        this.jumlahBukuDibayar = jumlahBukuDibayar;
        this.kategoriDenda = kategoriDenda;
        this.jumlahDenda = jumlahDenda;
        this.statusKerusakan = statusKerusakan;
    }

    // Getters and setters
    public int getIdPeminjaman() {
        return idPeminjaman;
    }

    public void setIdPeminjaman(int idPeminjaman) {
        this.idPeminjaman = idPeminjaman;
    }

    public int getIdDenda() {
        return idDenda;
    }

    public void setIdDenda(int idDenda) {
        this.idDenda = idDenda;
    }

    public int getJumlahBukuDibayar() {
        return jumlahBukuDibayar;
    }

    public void setJumlahBukuDibayar(int jumlahBukuDibayar) {
        this.jumlahBukuDibayar = jumlahBukuDibayar;
    }

    public String getKategoriDenda() {
        return kategoriDenda;
    }

    public void setKategoriDenda(String kategoriDenda) {
        this.kategoriDenda = kategoriDenda;
    }

    public long getJumlahDenda() {
        return jumlahDenda;
    }

    public void setJumlahDenda(int jumlahDenda) {
        this.jumlahDenda = jumlahDenda;
    }

    public boolean isStatusKerusakan() {
        return statusKerusakan;
    }

    public void setStatusKerusakan(boolean statusKerusakan) {
        this.statusKerusakan = statusKerusakan;
    }   
}