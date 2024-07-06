package py.com.lincoln.todo_list_application.validators;

import py.com.lincoln.todo_list_application.entity.Tareas;

public class TareasValidator {

    public static void save(Tareas tarea) {

        if(tarea.getDescripcion() == null || tarea.getDescripcion().trim().isEmpty()) {
            throw new RuntimeException("La descripción es requerido");
        }

        if(tarea.getUsuario().getId() == null) {
            throw new RuntimeException("El codigo del usuario es requerido");
        }

        if(tarea.getDescripcion().length()> 150) {
            throw new RuntimeException("La descripcion es muy Largo");
        }
    }
}

