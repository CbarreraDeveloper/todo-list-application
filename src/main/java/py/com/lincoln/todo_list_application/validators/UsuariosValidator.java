package py.com.lincoln.todo_list_application.validators;

import py.com.lincoln.todo_list_application.entity.Usuarios;

public class UsuariosValidator {

    public static void save(Usuarios usuario) {

        if(usuario.getDescripcion() == null || usuario.getDescripcion().trim().isEmpty()) {
            throw new RuntimeException("La descripción es requerido");
        }

        if(usuario.getDescripcion().length()> 50) {
            throw new RuntimeException("La descripcion es muy Largo");
        }
    }
}
