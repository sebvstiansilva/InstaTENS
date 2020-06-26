package cl.sema.instatens.DTO;

import java.util.Date;
import java.util.List;

public class Usuario {
    private int idUsuario;
    private String nombre;
    private String apellidoPaterno;
    private String appellidoMaterno;
    private String password;
    private String sexo;
    private Date fechaNacimiento;
    private String telefono;
    private String mail;
    private List<Direccion> direcciones;
    private List<Familiar> familiares;

    public Usuario() {

    }

    public void AgregarDireccion(List<Direccion> direcciones) {
        this.direcciones = direcciones;
    }

    public void AgregarFamiliar(List<Familiar> familiares) {
        this.familiares = familiares;
    }

    public Usuario(int idUsuario, String nombre, String apellidoPaterno, String appellidoMaterno, String password, String sexo, Date fechaNacimiento, String telefono, String mail) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.appellidoMaterno = appellidoMaterno;
        this.password = password;
        this.sexo = sexo;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.mail = mail;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
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

    @Override
    public String toString() {
        return "Usuario " + this.nombre + " se ha registrado";
    }

    public String toJSON() {
        return toString();
    }
}
