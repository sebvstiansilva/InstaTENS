package cl.sema.instatens.DTO;

public class Direccion {
    private String region;
    private String comuna;
    private String calle;
    private int numero;
    private String departamento;
    private int idUsuario;

    public Direccion() {

    }

    public Direccion(String region, String comuna, String calle, int numero, String departamento, int idUsuario) {
        this.region = region;
        this.comuna = comuna;
        this.calle = calle;
        this.numero = numero;
        this.departamento = departamento;
        this.idUsuario = idUsuario;
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

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}
