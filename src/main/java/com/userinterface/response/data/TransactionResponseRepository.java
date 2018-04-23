package com.userinterface.response.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.userinterface.model.TransactionResponse;

@Repository

public class TransactionResponseRepository  {

	@Autowired	
	JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	class TransactionResponseRowMapper implements RowMapper < TransactionResponse > {

		@Override
		public TransactionResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			TransactionResponse response=instantiateTransactionResponse();
			response.setId(rs.getInt("id"));
	        response.setTransactionDate(rs.getString("transactionDate"));
	        response.setTransactionTime(rs.getString("transactionTime"));
	        response.setTransactionType(rs.getString("transactionType"));
	        response.setPatientFirstName(rs.getString("patientFirstName"));
	        response.setPatientLastName(rs.getString("patientLastName"));
	        response.setPayer(rs.getString("payer"));
	        response.setServiceProvider(rs.getString("serviceProvider"));
	        response.setAdmissionDate(rs.getString("admissionDate"));
	        response.setFacilityTypeCode(rs.getString("facilityTypeCode"));
	        response.setReviewDecisionReasonCode(rs.getString("reviewDecisionReasonCode"));
	        response.setReviewIdentificationNumber(rs.getString("reviewIdentificationNumber"));
	        response.setCertificationActionCode(rs.getString("certificationActionCode"));
	        System.out.println("rowmapper:------------"+response.getCertificationActionCode());
			return response;
		}

		TransactionResponse instantiateTransactionResponse() {
			return new TransactionResponse();
		}
	       
	}
	
	public List<TransactionResponse> findAll()  {
		System.out.println("find all:------------");
       return jdbcTemplate.query("select * from transactionresponse", new TransactionResponseRowMapper());
        

	}

public int deleteAll() {
        return jdbcTemplate.update("delete transactionresponse");
}

public int insert(TransactionResponse response) {
        return jdbcTemplate.update("insert into transactionresponse  " + "values(?,  ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",

            new Object[] {
            		1,response.getTransactionDate(),response.getTransactionTime(),response.getTransactionType(),
   	             response.getPatientFirstName(),response.getPatientLastName(),response.getPayer(),response.getServiceProvider(),
   	             response.getAdmissionDate(),response.getFacilityTypeCode(),response.getCertificationActionCode(),response.getReviewIdentificationNumber()	             
   	             ,response.getReviewDecisionReasonCode()
            });

    }
}
