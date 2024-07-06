package py.com.lincoln.services;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import py.com.lincoln.entity.Usuarios;
import py.com.lincoln.exceptions.GeneralServiceException;
import py.com.lincoln.exceptions.NoDataFoundException;
import py.com.lincoln.exceptions.ValidateServiceException;
import py.com.lincoln.repository.UsuariosRepository;


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

}
