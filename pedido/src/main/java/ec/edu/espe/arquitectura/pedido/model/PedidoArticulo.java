package ec.edu.espe.arquitectura.pedido.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "PEDIDO_ARTICULO")

public class PedidoArticulo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ARTICULO_ID", nullable = false)
    private Integer id;
    @Column(name = "PEDIDO_ID", nullable = false)
    private Integer pedidoId;
    @Column(name = "DESCRIPCION", length = 200, nullable = false)
    private String descripcion;
    
    @ManyToOne
    @JoinColumn(name = "PEDIDO_ID", referencedColumnName = "PEDIDO_ID", insertable = false, updatable = false, nullable = false)
    private DetallePedido detallePedido;

    public PedidoArticulo() {
    }

    public PedidoArticulo(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Integer pedidoId) {
        this.pedidoId = pedidoId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public DetallePedido getDetallePedido() {
        return detallePedido;
    }

    public void setDetallePedido(DetallePedido detallePedido) {
        this.detallePedido = detallePedido;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PedidoArticulo other = (PedidoArticulo) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "PedidoArticulo [id=" + id + ", pedidoId=" + pedidoId + ", descripcion=" + descripcion
                + ", detallePedido=" + detallePedido + "]";
    }

    
    

    
}
