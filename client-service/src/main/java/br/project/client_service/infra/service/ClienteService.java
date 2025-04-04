package br.project.client_service.infra.service;

import br.project.client_service.domain.entities.Cliente;
import br.project.client_service.infra.repositories.ClienteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente createCliente(Cliente cLiente){
        return clienteRepository.save(cLiente);
    }

    public List<Cliente> getAllCliente(){
        return clienteRepository.findAll();
    }

    public Cliente getClienteById(Long id){
        return clienteRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
    }

    public void deleteCliente(Long id){
        if(!clienteRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado");
        }
        clienteRepository.deleteById(id);
    }
}
