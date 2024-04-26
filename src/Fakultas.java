public class Fakultas {
    private int idFakultas;
    private String namaFakultas;

    public Fakultas(int idFakultas, String namaFakultas) {
        this.idFakultas = idFakultas;
        this.namaFakultas = namaFakultas;
    }

    // Getter dan Setter
    public int getIdFakultas() {
        return idFakultas;
    }

    public void setIdFakultas(int idFakultas) {
        this.idFakultas = idFakultas;
    }

    public String getNamaFakultas() {
        return namaFakultas;
    }

    public void setNamaFakultas(String namaFakultas) {
        this.namaFakultas = namaFakultas;
    }
}