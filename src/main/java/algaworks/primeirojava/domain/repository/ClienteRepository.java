package algaworks.primeirojava.domain.repository;

import algaworks.primeirojava.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClienteRepository extends JpaRepository <Cliente, Long>  {

}