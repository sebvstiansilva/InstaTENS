package cl.sema.instatens.DAO;

import java.util.ArrayList;
import java.util.List;

import cl.sema.instatens.DTO.Usuario;

public class UsuarioDAO {

    private static List<Usuario> usuarios = new ArrayList<>();

    public static List<Usuario> getUsuarioList() {
        return usuarios;
    }

    public void addUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }
}
