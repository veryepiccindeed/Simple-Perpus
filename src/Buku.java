public class Buku {
    private int idBuku;
    private String judulBuku;
    private String pengarang;
    private String penerbit;
    private int tahunTerbit;
    private String edisiTerbit;
    private String jenisSampul;
    private String kategori;

    public Buku(){}

    public Buku(int idBuku, String judulBuku, String pengarang, String penerbit, int tahunTerbit, String edisiTerbit, String jenisSampul, String kategori) {
        this.idBuku = idBuku;
        this.judulBuku = judulBuku;
        this.pengarang = pengarang;
        this.penerbit = penerbit;
        this.tahunTerbit = tahunTerbit;
        this.edisiTerbit = edisiTerbit;
        this.jenisSampul = jenisSampul;
        this.kategori = kategori;
    }

    // Getter dan Setter
    public int getIdBuku() {
        return idBuku;
    }

    public void setIdBuku(int idBuku) {
        this.idBuku = idBuku;
    }

    public String getJudulBuku() {
        return judulBuku;
    }

    public void setJudulBuku(String judulBuku) {
        this.judulBuku = judulBuku;
    }

    public String getPengarang() {
        return pengarang;
    }

    public void setPengarang(String pengarang) {
        this.pengarang = pengarang;
    }

    public String getPenerbit() {
        return penerbit;
    }

    public void setPenerbit(String penerbit) {
        this.penerbit = penerbit;
    }

    public int getTahunTerbit() {
        return tahunTerbit;
    }

    public void setTahunTerbit(int tahunTerbit) {
        this.tahunTerbit = tahunTerbit;
    }

    public String getEdisiTerbit() {
        return edisiTerbit;
    }

    public void setEdisiTerbit(String edisiTerbit) {
        this.edisiTerbit = edisiTerbit;
    }

    public String getJenisSampul() {
        return jenisSampul;
    }

    public void setJenisSampul(String jenisSampul) {
        this.jenisSampul = jenisSampul;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getInfo() {
        return idBuku + " | " + judulBuku + " | " + pengarang + " | " + penerbit + 
               " | " + tahunTerbit + " | " + edisiTerbit + " | " + jenisSampul + " | " + kategori;
    }
    
}
