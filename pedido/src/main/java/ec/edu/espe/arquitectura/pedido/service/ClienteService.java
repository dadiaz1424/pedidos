package ec.edu.espe.arquitectura.pedido.service;


import java.util.Optional;

import org.springframework.stereotype.Service;

import ec.edu.espe.arquitectura.pedido.model.Cliente;
import ec.edu.espe.arquitectura.pedido.repository.ClienteRepository;
import jakarta.transaction.Transactional;

@Service
public class ClienteService {
    
    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    
    public Optional<Cliente> obtainByCode(Integer code) {
        return this.clienteRepository.findById(code);
    }

    @Transactional
    public Cliente create(Cliente cliente) {
       Optional<Cliente> clienteTmp = this.clienteRepository.findById(cliente.getId());
        if (clienteTmp == null) {
            return this.clienteRepository.save(cliente);
        } else {
            throw new RuntimeException("Cliente ya existe");
        }
    }

    @Transactional
    public Cliente update(Cliente cliente) {
        Optional<Cliente> clienteOpt = this.clienteRepository.findById(cliente.getId());
        if (clienteOpt.isPresent()) {
            Cliente clienteTmp = clienteOpt.get();  //memoria del entity manager
            clienteTmp.setSaldo(cliente.getSaldo());
            clienteTmp.setLimiteCredito(cliente.getLimiteCredito());
            clienteTmp.setDescuento(cliente.getDescuento());
            this.clienteRepository.save(clienteTmp); //update
            return clienteTmp;
        } else {
            throw new RuntimeException("Cliente que desea modificar no esta registrado");
        }
    }

    @Transactional
    public void delete(Integer clienteCode) {
        try {
            Optional<Cliente> clienteOpt =  this.clienteRepository.findById(clienteCode);
            if (clienteOpt.isPresent()) {
                this.clienteRepository.delete(clienteOpt.get());
            } else {
                throw new RuntimeException("El cliente no esta registrado: "+clienteCode);
            }
        } catch (RuntimeException rte) {
            throw new RuntimeException("No se puede eliminar el cliente con Codigo: "+ clienteCode, rte);
        }
    }


}

