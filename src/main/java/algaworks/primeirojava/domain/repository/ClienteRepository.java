package algaworks.primeirojava.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import algaworks.primeirojava.models.Cliente;
import java.util.List;


@Repository
public interface ClienteRepository extends JpaRepository <Cliente, Long>  {

    public List<Cliente> findByNome(String nome);
    public List<Cliente> findByNomeContaining(String nome);
    Cliente findByEmail(String email);

}