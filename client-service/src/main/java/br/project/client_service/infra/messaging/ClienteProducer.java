package br.project.client_service.infra.messaging;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ClienteProducer {

    private final RabbitTemplate rabbitTemplate;

    @Value("${spring.rabbitmq.queue}")
    private String queue;

    public ClienteProducer(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate = rabbitTemplate;
    }

    public void enviarMensagem(Object message){
        rabbitTemplate.convertAndSend(queue, message);
    }
}
