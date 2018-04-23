package com.userinterface.controller;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.userinterface.model.TransactionRequest;
import com.userinterface.model.TransactionResponse;
import com.userinterface.response.data.TransactionResponseRepository;
import com.userinterface.service.RabbitMQSender;

@RestController
@ComponentScan({"com.example.demo.controller"})
public class RabbitMQWebController {
	@Autowired
	TransactionResponseRepository response;
	
	public TransactionResponseRepository getResponse() {
		return response;
	}

	public void setResponse(TransactionResponseRepository response) {
		this.response = response;
	}


	@Autowired
	RabbitMQSender rabbitMQSender;

	public RabbitMQSender getRabbitMQSender() {
		return rabbitMQSender;
	}

	public void setRabbitMQSender(RabbitMQSender rabbitMQSender) {
		this.rabbitMQSender = rabbitMQSender;
	}

	@RequestMapping(value = "/producer", method = RequestMethod.GET)
	public RedirectView  producer(@RequestParam("firstName") String firstName,@RequestParam("lastName") String lastName,
							@RequestParam("payer") String payer,@RequestParam("admissionDate") String admissionDate, 
							@RequestParam("serviceProvider") String serviceProvider) {
	
	Calendar calobj = Calendar.getInstance(); 
	DateFormat time = new SimpleDateFormat("HH:mm:ss");
	DateFormat date = new SimpleDateFormat("dd/MM/yyyy");
	TransactionRequest pt=instantiateTransactionRequest();
	pt.setPatientFirstName(firstName);
	pt.setPatientLastName(lastName);
	pt.setPayer(payer);
	pt.setAdmissionDate(admissionDate);
	pt.setServiceProvider(serviceProvider);
	pt.setTransactionDate(date.format(new Date()));
	pt.setTransactionTime(time.format(calobj.getTime()));
	pt.setTransactionType("NOA");
	rabbitMQSender.send(pt);	
	System.out.println("Received Message:");
	RedirectView test = new RedirectView();
	test.setUrl("running.html");
	return test;
	}

	public TransactionRequest instantiateTransactionRequest() {
		return new TransactionRequest();
	}
		
	@RequestMapping(value = "running.html", method = RequestMethod.GET)
	public ModelAndView secondPage()  {
			
		ModelAndView map = new ModelAndView("running");
		
		map.addObject("running");
		//map.addAttribute("employees", allEmployees.get(0).getPatientFirstName());
		map.getModelMap().addAttribute("response");
		return map;
		//return new ModelAndView("allEmployees", "employees", allEmployees);

	}
	
	
	@RequestMapping(value = "/response", method = RequestMethod.GET)
	public ModelAndView response()  {
		
		List<TransactionResponse> allResponses = response.findAll();
		System.out.println("Recieved Message:------------"+allResponses);
		ModelAndView map = new ModelAndView("response");
		
		map.addObject("response", allResponses);
		//map.addAttribute("employees", allEmployees.get(0).getPatientFirstName());
		
		map.getModelMap().addAttribute("firstName", allResponses.get(0).getPatientFirstName());
		map.getModelMap().addAttribute("lastName", allResponses.get(0).getPatientLastName());
		map.getModelMap().addAttribute("serviceProvider", allResponses.get(0).getServiceProvider());
		map.getModelMap().addAttribute("payer", allResponses.get(0).getPayer());
		map.getModelMap().addAttribute("admissionDate", allResponses.get(0).getAdmissionDate());
		map.getModelMap().addAttribute("transactionDate", allResponses.get(0).getTransactionDate());
		map.getModelMap().addAttribute("transactionTime", allResponses.get(0).getTransactionTime());
		map.getModelMap().addAttribute("transactionType", allResponses.get(0).getTransactionType());
		map.getModelMap().addAttribute("facilityTypeCode", allResponses.get(0).getFacilityTypeCode());
		map.getModelMap().addAttribute("reviewDecisionReasonCode", allResponses.get(0).getReviewDecisionReasonCode());
		map.getModelMap().addAttribute("reviewIdentificationNumber", allResponses.get(0).getReviewIdentificationNumber());
		map.getModelMap().addAttribute("certificationActionCode", allResponses.get(0).getCertificationActionCode());
		return map;
		//return new ModelAndView("allEmployees", "employees", allEmployees);

	}


}


