package cl.sema.instatens.DTO;

/* Clase Dirección, contiene los datos de las direcciones que puede almacenar
*  cada usuario para cada atención que este requiera*/
public class Direccion {
    private int idDireccion;
    private String region;
    private String comuna;
    private String calle;
    private int numero;
    private int piso;
    private Usuario idUsuario;

    /* Constructor simple de la clase Dirección*/
    public Direccion() {

    }

    /* Constructor de la clase Direccion que es llamada automaticamente
       cuando se crea el objeto de esta clase*/
    public Direccion(int idDireccion, String region, String comuna, String calle, int numero, int piso, Usuario idUsuario) {
        this.idDireccion = idDireccion;
        this.region = region;
        this.comuna = comuna;
        this.calle = calle;
        this.numero = numero;
        this.piso = piso;
        this.idUsuario = idUsuario;
    }

    /* Funciones GET'S and SET'S de todos los atributos de la clase Direccion */
    public int getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(int idDireccion) {
        this.idDireccion = idDireccion;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }
}
