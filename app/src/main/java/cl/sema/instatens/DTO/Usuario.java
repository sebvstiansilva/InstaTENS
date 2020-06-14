package cl.sema.instatens.DTO;

import java.util.List;

public class Usuario {
    private String nombre;
    private String apellidoPaterno;
    private String appellidoMaterno;
    private String password;
    private String mail;
    private int telefono;
    private List<Direccion> direcciones;
    private List<Familiar> familiares;

    public Usuario() {

    }

    public Usuario(String nombre, String apellidoPaterno, String appellidoMaterno, String password, String mail, int telefono) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.appellidoMaterno = appellidoMaterno;
        this.password = password;
        this.mail = mail;
        this.telefono = telefono;
    }

    public List<Direccion> getDirecciones() {
        return direcciones;
    }

    public void setDirecciones(List<Direccion> direcciones) {
        this.direcciones = direcciones;
    }

    public List<Familiar> getFamiliares() {
        return familiares;
    }

    public void setFamiliares(List<Familiar> familiares) {
        this.familiares = familiares;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getAppellidoMaterno() {
        return appellidoMaterno;
    }

    public void setAppellidoMaterno(String appellidoMaterno) {
        this.appellidoMaterno = appellidoMaterno;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Usuario " + this.nombre + " se ha registrado";
    }
}
