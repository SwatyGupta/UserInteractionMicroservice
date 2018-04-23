package com.userinterface.service;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.userinterface.service.Subscriber;
import com.userinterface.model.TransactionResponse;
import com.userinterface.response.data.TransactionResponseRepository;
import com.userinterface.service.RabbitMQSender;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SubcriberTest {
	@Autowired
	RabbitMQSender rabbitMQSender;
	
	Subscriber subscriber = new Subscriber();
	TransactionResponse tRespnse = new TransactionResponse();
	TransactionResponseRepository transactionResponseRepository = new TransactionResponseRepository();
	
@Test
public void receivedMessage() {
	TransactionResponseRepository spy;
	spy = Mockito.spy(transactionResponseRepository);
	doReturn(1).when(spy).deleteAll(); 
	doReturn(1).when(spy).insert(tRespnse);
	subscriber.setRsp(spy);
	
	subscriber.receivedMessage(tRespnse);	
	verify(spy, times(1)).insert(tRespnse);
}

}