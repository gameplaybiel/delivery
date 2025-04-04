package br.project.client_service.infra.messaging;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQConsumer {

    @RabbitListener(queues = "fila_clientes")
    public void consumirMensagem(String mensagem){
        System.out.println("Mensagem recebida: " + mensagem);
    }
}
