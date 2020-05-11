package algaworks.primeirojava.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import algaworks.primeirojava.models.Comentario;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Long> {

}