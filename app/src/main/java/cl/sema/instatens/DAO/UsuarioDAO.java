package cl.sema.instatens.DAO;

import java.util.ArrayList;
import java.util.List;

import cl.sema.instatens.DTO.Usuario;

/* Patrón DAO de la clase Usuario que nos permite separar la logica de negocio
*  de la lógica para acceder a los datos*/
public class UsuarioDAO extends Usuario {

    /* Se define la lista de usuarios */
    private static List<Usuario> usuarios = new ArrayList<>();

    /* Función que retorna la lista de usuarios */
    public static List<Usuario> getUsuarioList() {
        return usuarios;
    }

    /* Función que retorna el usuario seleccionado */
    public static Usuario obtenerUsuario() {
        return usuarios.get(3);
    }

    /* Función que agrega un usuario */
    public void addUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }
}
