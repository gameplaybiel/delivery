package br.project.client_service.application.usecases;

import br.project.client_service.application.dto.ClienteRequestDTO;
import br.project.client_service.application.dto.ClienteResponseDTO;
import br.project.client_service.domain.entities.Cliente;
import br.project.client_service.infra.repositories.ClienteRepository;
import org.springframework.stereotype.Service;

@Service
public class RegisterClientUseCase {
    private final ClienteRepository clienteRepository;

    public RegisterClientUseCase(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public ClienteResponseDTO execute(ClienteRequestDTO requestDTO){
        Cliente cliente = new Cliente(null, requestDTO.getNome(), requestDTO.getCpf(),requestDTO.getEmail());
        Cliente savedCliente = clienteRepository.save(cliente);

        return new ClienteResponseDTO(savedCliente.getId(), savedCliente.getNome(), savedCliente.getCpf(), savedCliente.getEmail());
    }
}
