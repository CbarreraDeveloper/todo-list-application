package py.com.lincoln.todo_list_application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import py.com.lincoln.todo_list_application.entity.Tareas;

import java.util.List;

@Repository
public interface TareasRepository extends JpaRepository<Tareas, Long> {
    List<Tareas> findByUsuarioId(Long usuarioId);
}
