package naeli.primeirojava.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import naeli.primeirojava.models.Comentario;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Long> {

}