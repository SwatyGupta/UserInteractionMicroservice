package com.userinterface.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.userinterface.controller.RabbitMQWebController;
import com.userinterface.model.TransactionResponse;
import com.userinterface.response.data.TransactionResponseRepository;

@Component
public class Subscriber {
	
	@Autowired	
	JdbcTemplate jdbcTemplate;

	@Autowired
	TransactionResponseRepository rsp;
	
	public TransactionResponseRepository getRsp() {
		return rsp;
	}

	public void setRsp(TransactionResponseRepository rsp) {
		this.rsp = rsp;
	}

	@RabbitListener(queues="${response.rabbitmq.queue}")
    public void receivedMessage(TransactionResponse response) {
        System.out.println("Recieved Message: " + ""+response);
        
       rsp.deleteAll();
        rsp.insert(response);
        
     
    }
}