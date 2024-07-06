package py.com.lincoln.todo_list_application.converters;

import py.com.lincoln.todo_list_application.dtos.TareasDTO;
import py.com.lincoln.todo_list_application.dtos.UsuariosDTO;
import py.com.lincoln.todo_list_application.entity.Tareas;
import py.com.lincoln.todo_list_application.entity.Usuarios;

public class TareasConverter extends AbstractConverter<Tareas, TareasDTO>{

    @Override
    public TareasDTO fromEntity(Tareas entity) {
        return TareasDTO.builder()
                .id(entity.getId())
                .descripcion(entity.getDescripcion())
                .usuarioId(entity.getUsuario().getId())
                .usuarioDescri(entity.getUsuario().getDescripcion())
                .build();
    }

    @Override
    public Tareas fromDTO(TareasDTO dto) {
        return Tareas.builder()
                .id(dto.getId())
                .descripcion(dto.getDescripcion())
                .build();
    }

}



