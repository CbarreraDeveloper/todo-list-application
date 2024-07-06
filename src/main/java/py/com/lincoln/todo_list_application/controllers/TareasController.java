package py.com.lincoln.todo_list_application.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import py.com.lincoln.todo_list_application.converters.TareasConverter;
import py.com.lincoln.todo_list_application.dtos.TareasDTO;
import py.com.lincoln.todo_list_application.dtos.UsuariosDTO;
import py.com.lincoln.todo_list_application.entity.Tareas;
import py.com.lincoln.todo_list_application.entity.Usuarios;
import py.com.lincoln.todo_list_application.services.TareasServices;
import py.com.lincoln.todo_list_application.utils.WrapperResponse;

import java.util.List;

@RestController
public class TareasController {

    @Autowired
    private TareasServices tareaService;



    @GetMapping("/usuarios/{usuarioId}/tareas")
    public ResponseEntity<WrapperResponse<List<Tareas>>> findByUsuarioId(@PathVariable("usuarioId") Long usuarioId) {
        List <Tareas> tareas = tareaService.findByUsuarioId(usuarioId);
        return new WrapperResponse<>(true, "success", tareas)
                .createResponse(HttpStatus.OK);
    }

    @GetMapping("/tareas/{tareaId}")
    public ResponseEntity<WrapperResponse<Tareas>> findById(@PathVariable("tareaId") Long tareaId) {
        Tareas tarea = tareaService.findById(tareaId);
        return new WrapperResponse<>(true, "success", tarea)
                .createResponse(HttpStatus.OK);
    }

    @PostMapping("/usuarios/{usuarioId}/tareas")

    public ResponseEntity<WrapperResponse<Tareas>>  create(
            @PathVariable("usuarioId") Long usuarioId,
            @RequestBody Tareas tarea){
        Tareas nuevaTarea = tareaService.create(usuarioId, tarea);

        return new WrapperResponse<>(true, "Tarea creada exitosamente", nuevaTarea)
                .createResponse(HttpStatus.CREATED);

    }

}
