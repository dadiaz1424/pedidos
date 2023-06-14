package ec.edu.espe.arquitectura.pedido.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CLIENTE")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CLIENTE_ID", nullable = false)
    private Integer id;
    @Column(name = "SALDO", precision = 5, scale = 2, nullable = false)
    private BigDecimal saldo;
    @Column(name = "LIMITE_CREDITO", nullable = false)
    private Integer limiteCredito;
    @Column(name = "DESCUENTO", nullable = false)
    private Integer descuento;
    
    public Cliente() {
    }

    public Cliente(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public Integer getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(Integer limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    public Integer getDescuento() {
        return descuento;
    }

    public void setDescuento(Integer descuento) {
        this.descuento = descuento;
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
        Cliente other = (Cliente) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Cliente [id=" + id + ", saldo=" + saldo + ", limiteCredito=" + limiteCredito + ", descuento="
                + descuento + "]";
    }
    
    
    

}
