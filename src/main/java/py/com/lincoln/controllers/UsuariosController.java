package py.com.lincoln.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import py.com.lincoln.converters.UsuariosConverter;
import py.com.lincoln.dtos.UsuariosDTO;
import py.com.lincoln.entity.Usuarios;
import py.com.lincoln.services.UsuariosService;
import py.com.lincoln.utils.WrapperResponse;


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

}
