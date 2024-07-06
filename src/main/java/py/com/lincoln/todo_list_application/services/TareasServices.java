package py.com.lincoln.todo_list_application.services;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import py.com.lincoln.todo_list_application.entity.Tareas;
import py.com.lincoln.todo_list_application.entity.Usuarios;
import py.com.lincoln.todo_list_application.exceptions.GeneralServiceException;
import py.com.lincoln.todo_list_application.exceptions.NoDataFoundException;
import py.com.lincoln.todo_list_application.exceptions.ValidateServiceException;
import py.com.lincoln.todo_list_application.repository.TareasRepository;
import py.com.lincoln.todo_list_application.repository.UsuariosRepository;
import py.com.lincoln.todo_list_application.validators.TareasValidator;
import py.com.lincoln.todo_list_application.validators.UsuariosValidator;

import java.util.List;


@Slf4j
@Service
public class TareasServices {

    @Autowired
    private TareasRepository tareaRepo;

    @Autowired
    private UsuariosRepository usuarioRepo;

    public Tareas findById(Long tareaId) {
        try {
            Tareas tarea = tareaRepo.findById(tareaId)
                    .orElseThrow(() -> new NoDataFoundException("La tarea no existe"));
            return tarea;
        } catch(ValidateServiceException | NoDataFoundException e) {
            log.info(e.getMessage(), e);
            throw e;
        }catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new GeneralServiceException(e.getMessage(), e);
        }
    }

    public List<Tareas> findByUsuarioId(Long usuarioId) {
        return tareaRepo.findByUsuarioId(usuarioId);
    }


    public Tareas create(Long usuarioId, Tareas tarea) {
        Usuarios usuario = usuarioRepo.findById(usuarioId)
                .orElseThrow(() -> new NoDataFoundException("El usuario no existe"));

        tarea.setUsuario(usuario);
        return tareaRepo.save(tarea);
    }


}
