package py.com.lincoln.todo_list_application.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class UsuariosDTO {
    private Long id;
    private String descripcion;
}
