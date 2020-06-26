package cl.sema.instatens.DTO;

/* Clase Familiar, contiene los datos de los familiares que puede almacenar
*  un usuario. Este familiar puede ser asignado por el usuario y dirigir la atención
*  del TENS hacia el  */
public class Familiar {
    private int idFamiliar;
    private String nombreFam;
    private String paternoFam;
    private String maternoFam;
    private String sexoFam;
    private Usuario idUsuario;

    /* Constructor simple de la clase Familiar*/
    public Familiar() {
    }

    /* Constructor de la clase Familiar que es llamada automaticamente
       cuando se crea el objeto de esta clase*/
    public Familiar(int idFamiliar, String nombreFam, String paternoFam, String maternoFam, String sexoFam, Usuario idUsuario) {
        this.idFamiliar = idFamiliar;
        this.nombreFam = nombreFam;
        this.paternoFam = paternoFam;
        this.maternoFam = maternoFam;
        this.sexoFam = sexoFam;
        this.idUsuario = idUsuario;
    }

    /* Funciones GET'S and SET'S de todos los atributos de la clase Familiar */
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

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }
}
