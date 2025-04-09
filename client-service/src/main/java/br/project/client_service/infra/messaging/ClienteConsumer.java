package br.project.client_service.infra.messaging;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ClienteConsumer {

    @RabbitListener(queues = "cliente.queue")
    public void consumirMensagem(String message){
        System.out.println("Mensagem recebida: " + message);
    }
}
