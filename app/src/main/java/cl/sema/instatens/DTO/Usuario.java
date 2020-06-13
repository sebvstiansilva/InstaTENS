package cl.sema.instatens.DTO;

public class Usuario {
    private String rut;
    private String name;
    private String password;
    private String mail;
    private int phone;

    public Usuario() {

    }

    public Usuario(String rut, String name, String password, String mail, int phone) {
        this.rut = rut;
        this.name = name;
        this.password = password;
        this.mail = mail;
        this.phone = phone;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Usuario " + this.rut + " se ha registrado";
    }
}
