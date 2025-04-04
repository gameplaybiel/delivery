package br.project.client_service.infra.messaging;

import org.springframework.context.annotation.Bean;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMQConfig {
    @Bean
    public Queue filaClientes(){
        return new Queue("fila_clientes", true);
    }
}
