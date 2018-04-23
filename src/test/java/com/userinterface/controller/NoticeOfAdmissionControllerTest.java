package com.userinterface.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.mockito.Mockito;

public class NoticeOfAdmissionControllerTest {

	NoticeOfAdmissionController noticeOfAdmissionController = new NoticeOfAdmissionController();
	
	@Test
	public void homepageTest() {

		NoticeOfAdmissionController spy;
		 spy = Mockito.spy(noticeOfAdmissionController);
		assertEquals("noarequest" , spy.homepage()) ;
	}
}
