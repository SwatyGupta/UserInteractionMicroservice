package com.userinterface.service;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.userinterface.model.TransactionRequest;
import com.userinterface.model.TransactionResponse;


public class RabbitMQSenderTest {
	
	RabbitMQSender rabbitMQSender  = new RabbitMQSender();
	
	TransactionRequest tReq = new TransactionRequest();
	
	 @Test
    public void rabbitTemplate() {
		 RabbitTemplate amqpTemplate = Mockito.mock(RabbitTemplate.class);
		 RabbitMQSender spy;
		 spy = Mockito.spy(rabbitMQSender);
		
		 spy.setAmqpTemplate(amqpTemplate);
		 spy.send(tReq);
		 verify(spy, times(1)).send(tReq);
    }
	 
	 @Test
	  public void testamqpTemplate() {
		 RabbitTemplate amqpTemplate = Mockito.mock(RabbitTemplate.class);
		 RabbitMQSender spy;
		 spy = Mockito.spy(rabbitMQSender);
		 spy.setAmqpTemplate(amqpTemplate);
     assertEquals(amqpTemplate,spy.getAmqpTemplate());
}
}
