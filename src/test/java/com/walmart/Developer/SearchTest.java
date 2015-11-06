package com.walmart.Developer;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.walmart.service.TicketService;
import com.walmart.service.TicketServiceImpl;

public class SearchTest {

	private TicketService o;
	@Before
    public void setUp(){
        o = new TicketServiceImpl();
    }
	
	  @After
	  public void AfterExec(){
		  
		  System.out.println("FINISHED SEARCH");
	  }
	  
	@Test
	public void test(){
		
		
		assertEquals(o.numSeatsAvailable(1),1250);
	}
	
}
