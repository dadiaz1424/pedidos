package ec.edu.espe.arquitectura.pedido.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.edu.espe.arquitectura.pedido.model.PedidoArticulo;
@Repository
public interface PedidoArticuloRepository extends JpaRepository <PedidoArticulo, Integer> {

   
    
}
