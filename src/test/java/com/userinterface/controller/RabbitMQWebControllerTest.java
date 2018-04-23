package com.userinterface.controller;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;

import java.util.ArrayList;

import org.junit.Test;
import org.mockito.Mockito;

import com.userinterface.model.TransactionRequest;
import com.userinterface.model.TransactionResponse;
import com.userinterface.response.data.TransactionResponseRepository;
import com.userinterface.service.RabbitMQSender;

public class RabbitMQWebControllerTest {

	RabbitMQWebController rabbitMQWebController  = new RabbitMQWebController();
	RabbitMQSender rabbitMQSender  = Mockito.mock(RabbitMQSender.class);
	@Test
	public void testProducer() {

		 RabbitMQWebController spy;
		 spy = Mockito.spy(rabbitMQWebController);
		 spy.setRabbitMQSender(rabbitMQSender);
		 TransactionRequest rq=new TransactionRequest();
		 doReturn(rq).when(spy).instantiateTransactionRequest();  
		 spy.producer("firstName", "lastName", "payer", "admissionDate", "serviceProvider");
		 assertEquals("firstName",rq.getPatientFirstName());
		 assertEquals("lastName",rq.getPatientLastName());
		 assertEquals("payer",rq.getPayer());
		 assertEquals("admissionDate",rq.getAdmissionDate());
		 assertEquals("serviceProvider",rq.getServiceProvider());    
	}
	
	@Test
	public void testresponse() {
		
		 RabbitMQWebController spy;
		 spy = Mockito.spy(rabbitMQWebController);
		 TransactionResponseRepository test = Mockito.spy(TransactionResponseRepository.class);;
		 spy.setResponse(test);
		 TransactionResponse rq=new TransactionResponse();
		 rq.setPatientFirstName("Swaty");
		 rq.setPatientLastName("Gupta");
		 ArrayList test1 = new ArrayList();
		 test1.add(rq);
		 doReturn(test1).when(test).findAll();  
		 spy.response();
		 assertEquals("Swaty",rq.getPatientFirstName());
		 assertEquals("Gupta",rq.getPatientLastName());
	}
	
}
