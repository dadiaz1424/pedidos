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
@Table(name = "CLIENTE_DIRECCION")
public class ClienteDireccion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "DIRECCION_ID", nullable = false)
    private Integer id;
    @Column(name = "CLIENTE_ID", nullable = false)
    private Integer clienteId;
    @Column(name = "NUMERO", nullable = false)
    private Integer numero;
    @Column(name = "CALLE", length = 60, nullable = false)
    private String calle;
    @Column(name = "BARRIO", length = 60, nullable = false)
    private String barrio;
    @Column(name = "CIUDAD", length = 60, nullable = false)
    private String ciudad;

    @ManyToOne
    @JoinColumn(name = "CLIENTE_ID", referencedColumnName = "CLIENTE_ID", insertable = false, updatable = false, nullable = false)
    private Cliente cliente;

    public ClienteDireccion() {
    }

    public ClienteDireccion(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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
        ClienteDireccion other = (ClienteDireccion) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "ClienteDireccion [id=" + id + ", clienteId=" + clienteId + ", numero=" + numero + ", calle=" + calle
                + ", barrio=" + barrio + ", ciudad=" + ciudad + ", cliente=" + cliente + "]";
    }

    

    




    
}
