package cl.sema.instatens.DAO;

import java.util.ArrayList;
import java.util.List;

import cl.sema.instatens.DTO.Usuario;

public class UsuarioDAO extends Usuario {

    private static List<Usuario> usuarios = new ArrayList<>();

    public static List<Usuario> getUsuarioList() {
        return usuarios;
    }
    public static Usuario obtenerUsuario() {
        return usuarios.get(3);
    }
    public void addUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }
}
