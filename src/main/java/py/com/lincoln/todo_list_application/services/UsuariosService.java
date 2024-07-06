package py.com.lincoln.todo_list_application.services;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import py.com.lincoln.todo_list_application.entity.Usuarios;
import py.com.lincoln.todo_list_application.exceptions.GeneralServiceException;
import py.com.lincoln.todo_list_application.exceptions.NoDataFoundException;
import py.com.lincoln.todo_list_application.exceptions.ValidateServiceException;
import py.com.lincoln.todo_list_application.repository.UsuariosRepository;

import java.util.List;


@Slf4j
@Service
public class UsuariosService {

    @Autowired
    private UsuariosRepository usuarioRepo;

    public Usuarios findById(Long usuarioId) {
        try {
            log.debug("findById => " + usuarioId);
            Usuarios usuario = usuarioRepo.findById(usuarioId)
                    .orElseThrow(() -> new NoDataFoundException("El Usuario no existe"));
            return usuario;
        } catch(ValidateServiceException | NoDataFoundException e) {
            log.info(e.getMessage(), e);
            throw e;
        }catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new GeneralServiceException(e.getMessage(), e);
        }
    }

    public List<Usuarios> findAll(Pageable page){
        try {
            List<Usuarios> products = usuarioRepo.findAll(page).toList();
            return products;
        } catch (ValidateServiceException | NoDataFoundException e) {
            log.info(e.getMessage(), e);
            throw e;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new GeneralServiceException(e.getMessage(), e);
        }
    }



}
