package py.com.lincoln.todo_list_application.converters;


import py.com.lincoln.todo_list_application.dtos.UsuariosDTO;
import py.com.lincoln.todo_list_application.entity.Usuarios;

public class UsuariosConverter extends AbstractConverter<Usuarios, UsuariosDTO>{

    @Override
    public UsuariosDTO fromEntity(Usuarios entity) {
        return UsuariosDTO.builder()
                .id(entity.getId())
                .descripcion(entity.getDescripcion())
                .build();
    }

    @Override
    public Usuarios fromDTO(UsuariosDTO dto) {
        return Usuarios.builder()
                .id(dto.getId())
                .descripcion(dto.getDescripcion())
                .build();
    }

}
