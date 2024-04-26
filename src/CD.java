// Kelas CD
public class CD {
    private int idCD;
    private String judulCD;
    private String kategoriCD;
    private int tahunPublikasi;

    public CD(int idCD, String judulCD, String kategoriCD, int tahunPublikasi) {
        this.idCD = idCD;
        this.judulCD = judulCD;
        this.kategoriCD = kategoriCD;
        this.tahunPublikasi = tahunPublikasi;
    }

    // Getter dan Setter
    public int getIdCD() {
        return idCD;
    }

    public void setIdCD(int idCD) {
        this.idCD = idCD;
    }

    public String getJudulCD() {
        return judulCD;
    }

    public void setJudulCD(String judulCD) {
        this.judulCD = judulCD;
    }

    public String getKategoriCD() {
        return kategoriCD;
    }

    public void setKategoriCD(String kategoriCD) {
        this.kategoriCD = kategoriCD;
    }

    public int getTahunPublikasi() {
        return tahunPublikasi;
    }

    public void setTahunPublikasi(int tahunPublikasi) {
        this.tahunPublikasi = tahunPublikasi;
    }
}
