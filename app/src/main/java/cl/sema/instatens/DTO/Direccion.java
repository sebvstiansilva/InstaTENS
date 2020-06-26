package cl.sema.instatens.DTO;

public class Direccion {
    private int idDireccion;
    private String region;
    private String comuna;
    private String calle;
    private int numero;
    private int piso;
    private Usuario idUsuario;

    public Direccion() {

    }

    public Direccion(int idDireccion, String region, String comuna, String calle, int numero, int piso, Usuario idUsuario) {
        this.idDireccion = idDireccion;
        this.region = region;
        this.comuna = comuna;
        this.calle = calle;
        this.numero = numero;
        this.piso = piso;
        this.idUsuario = idUsuario;
    }

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
