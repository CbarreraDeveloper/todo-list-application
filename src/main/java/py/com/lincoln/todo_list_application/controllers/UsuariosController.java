package py.com.lincoln.todo_list_application.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import py.com.lincoln.todo_list_application.converters.UsuariosConverter;
import py.com.lincoln.todo_list_application.dtos.UsuariosDTO;
import py.com.lincoln.todo_list_application.entity.Usuarios;
import py.com.lincoln.todo_list_application.services.UsuariosService;
import py.com.lincoln.todo_list_application.utils.WrapperResponse;

import java.util.List;


@RestController
public class UsuariosController {

    @Autowired
    private UsuariosService usuarioService;

    private UsuariosConverter converter = new UsuariosConverter();

    @GetMapping(value="/usuarios/{usuarioId}")
    public ResponseEntity<WrapperResponse<UsuariosDTO>> findById(@PathVariable("usuarioId") Long usuarioId) {
        Usuarios usuario = usuarioService.findById(usuarioId);
        UsuariosDTO usuariosDTO = converter.fromEntity(usuario);
        return new WrapperResponse<UsuariosDTO>(true, "success", usuariosDTO)
                .createResponse(HttpStatus.OK);
    }

    @GetMapping(value="/usuarios")
    public ResponseEntity<List<UsuariosDTO>> findAll(
            @RequestParam(value="pageNumber", required = false, defaultValue = "0") int pageNumber,
            @RequestParam(value="pageSize", required = false, defaultValue = "5") int pageSize
    ){

        Pageable page = PageRequest.of(pageNumber, pageSize);
        List<Usuarios> usuario = usuarioService.findAll(page);
        List<UsuariosDTO> dtoProducts = converter.fromEntity(usuario);

        return new WrapperResponse(true, "success", dtoProducts)
                .createResponse(HttpStatus.OK);
    }

    @PostMapping(value="/usuarios")
    public ResponseEntity<UsuariosDTO> create(@RequestBody UsuariosDTO usuario){
        Usuarios nuevoUsuario = usuarioService.create(converter.fromDTO(usuario));
        UsuariosDTO usuarioDTO = converter.fromEntity(nuevoUsuario);
        return new ResponseEntity<UsuariosDTO>(usuarioDTO, HttpStatus.CREATED);

    }

}
