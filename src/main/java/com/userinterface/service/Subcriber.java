package com.userinterface.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.userinterface.controller.RabbitMQWebController;
import com.userinterface.model.TransactionResponse;
import com.userinterface.response.data.TransactionResponseRepository;

@Component
public class Subcriber {
	
	@Autowired	
	JdbcTemplate jdbcTemplate;

	@Autowired
	TransactionResponseRepository rsp;
	
	@RabbitListener(queues="${response.rabbitmq.queue}")
    public void recievedMessage(TransactionResponse response) {
        System.out.println("Recieved Message: " + ""+response);
        
        rsp.deleteAll();
        rsp.insert(response);
        
     
    }
}