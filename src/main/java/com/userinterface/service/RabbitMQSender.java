package com.userinterface.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.userinterface.model.TransactionRequest;


@Service
public class RabbitMQSender {
	
	@Autowired
	private AmqpTemplate amqpTemplate;
	
	public AmqpTemplate getAmqpTemplate() {
		return amqpTemplate;
	}

	public void setAmqpTemplate(AmqpTemplate amqpTemplate) {
		this.amqpTemplate = amqpTemplate;
	}

	@Value("${noa.rabbitmq.exchange}")
	private String exchange;
	
	@Value("${noa.rabbitmq.routingkey}")
	private String routingkey;	
	String kafkaTopic = "java_in_use_topic";
	
	public void send(TransactionRequest request) {
		amqpTemplate.convertAndSend(exchange, routingkey, request);
		System.out.println("Send msg = " + request);
	    
	}
}