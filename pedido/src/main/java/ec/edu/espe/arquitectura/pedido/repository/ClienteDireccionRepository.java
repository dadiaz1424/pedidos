package ec.edu.espe.arquitectura.pedido.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.edu.espe.arquitectura.pedido.model.ClienteDireccion;
@Repository
public interface ClienteDireccionRepository extends JpaRepository<ClienteDireccion, Integer> {

  

    
}