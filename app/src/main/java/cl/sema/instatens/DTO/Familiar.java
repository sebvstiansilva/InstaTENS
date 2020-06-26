package cl.sema.instatens.DTO;

public class Familiar {
    private int idFamiliar;
    private String nombreFam;
    private String paternoFam;
    private String maternoFam;
    private String sexoFam;
    private int idUsuario;

    public Familiar() {
    }

    public Familiar(int idFamiliar, String nombreFam, String paternoFam, String maternoFam, String sexoFam, int idUsuario) {
        this.idFamiliar = idFamiliar;
        this.nombreFam = nombreFam;
        this.paternoFam = paternoFam;
        this.maternoFam = maternoFam;
        this.sexoFam = sexoFam;
        this.idUsuario = idUsuario;
    }

    public int getIdFamiliar() {
        return idFamiliar;
    }

    public void setIdFamiliar(int idFamiliar) {
        this.idFamiliar = idFamiliar;
    }

    public String getNombreFam() {
        return nombreFam;
    }

    public void setNombreFam(String nombreFam) {
        this.nombreFam = nombreFam;
    }

    public String getPaternoFam() {
        return paternoFam;
    }

    public void setPaternoFam(String paternoFam) {
        this.paternoFam = paternoFam;
    }

    public String getMaternoFam() {
        return maternoFam;
    }

    public void setMaternoFam(String maternoFam) {
        this.maternoFam = maternoFam;
    }

    public String getSexoFam() {
        return sexoFam;
    }

    public void setSexoFam(String sexoFam) {
        this.sexoFam = sexoFam;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}
