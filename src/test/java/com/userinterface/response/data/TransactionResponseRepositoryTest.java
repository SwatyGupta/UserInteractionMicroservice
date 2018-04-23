package com.userinterface.response.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.userinterface.model.TransactionResponse;
import com.userinterface.response.data.TransactionResponseRepository.TransactionResponseRowMapper;

public class TransactionResponseRepositoryTest {
	TransactionResponseRepository transactionResponseRepository = new TransactionResponseRepository();
	TransactionResponseRowMapper transactionResponseRowMapper = transactionResponseRepository.new TransactionResponseRowMapper();
	
	@Test
	public void mapRowTest() throws SQLException {
		TransactionResponseRowMapper spy;
		spy = Mockito.spy(transactionResponseRowMapper);
		TransactionResponse tRespnse = new TransactionResponse();
		doReturn(tRespnse).when(spy).instantiateTransactionResponse(); 
		
		ResultSet rs = Mockito.mock(ResultSet.class);
		
		when(rs.getString("transactionDate")).thenReturn("04/23/2018");
		when(rs.getString("transactionTime")).thenReturn("12:58");
		when(rs.getString("transactionType")).thenReturn("NOA");
		when(rs.getString("patientFirstName")).thenReturn("Divya");
		when(rs.getString("patientLastName")).thenReturn("Mishra");
		when(rs.getString("payer")).thenReturn("Aetna");
		when(rs.getString("serviceProvider")).thenReturn("ILS");
		when(rs.getString("admissionDate")).thenReturn("04/20/2018");
		when(rs.getString("facilityTypeCode")).thenReturn("21");
		when(rs.getString("reviewDecisionReasonCode")).thenReturn("AH65435237");
		when(rs.getString("reviewIdentificationNumber")).thenReturn("8765430200");
		when(rs.getString("certificationActionCode")).thenReturn("A6");
		
		spy.mapRow(rs, 13);
		
		assertEquals("04/23/2018",tRespnse.getTransactionDate());
		assertEquals("12:58",tRespnse.getTransactionTime());
		assertEquals("NOA",tRespnse.getTransactionType());
		assertEquals("Divya",tRespnse.getPatientFirstName());
		assertEquals("Mishra",tRespnse.getPatientLastName());
		assertEquals("Aetna",tRespnse.getPayer());
		assertEquals("ILS",tRespnse.getServiceProvider());
		assertEquals("04/20/2018",tRespnse.getAdmissionDate());
		assertEquals("21",tRespnse.getFacilityTypeCode());
		assertEquals("AH65435237",tRespnse.getReviewDecisionReasonCode());
		assertEquals("8765430200",tRespnse.getReviewIdentificationNumber());
		assertEquals("A6",tRespnse.getCertificationActionCode());
		
	}
	
	@Test
	public void findAllTest() {
		TransactionResponseRepository spy;
		spy = Mockito.spy(transactionResponseRepository);
		
		FakeJDBCTemplate jdbcTemplate = new FakeJDBCTemplate();
		spy.setJdbcTemplate(jdbcTemplate);
		 
		List name = spy.findAll();
		assertNotNull(name);
		assertEquals(1, name.size());
	}
	
	@Test
	public void detletAllTest() {
		TransactionResponseRepository spy;
		spy = Mockito.spy(transactionResponseRepository);
		
		FakeJDBCTemplate jdbcTemplate = new FakeJDBCTemplate();
		spy.setJdbcTemplate(jdbcTemplate);
		 
		int name = spy.deleteAll();
		
		assertEquals(0, name);
	}
	
	class FakeJDBCTemplate extends JdbcTemplate {
		@SuppressWarnings("unchecked")
		@Override
		public List query(String sql , RowMapper rowMapper) {
			List list = new ArrayList();
			
				try {
					list.add(rowMapper.mapRow(resultSet(), 0));
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			
			return list;
		}
		
		@Override
		public int update(String sql) {
			List list = new ArrayList();
			return list.size();
		}

		private ResultSet resultSet() {
			ResultSet mockResultSet =  Mockito.mock(ResultSet.class);
			return mockResultSet;
		}
	}
		
}
