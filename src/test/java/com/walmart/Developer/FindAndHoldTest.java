package com.walmart.Developer;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.walmart.domain.SeatHold;
import com.walmart.service.TicketService;
import com.walmart.service.TicketServiceImpl;

public class FindAndHoldTest {

	private TicketService o;
	private SeatHold seathold;
	private Map<Integer, Integer> seatHoldMap = new HashMap<Integer, Integer>();
	private Map<Integer, Integer> seatHoldUpdated = new HashMap<Integer, Integer>();
    private String reservationCode;
	@Before
	public void setUp() {
		o = new TicketServiceImpl();
		seathold = new SeatHold();

		// setting the seatHold Object

		seathold.setSeatHoldNo(20); // 20 seats are in hold
		seathold.setCustomerEmail("shakya.suraj07@gmail.com");
		seathold.setSeatHoldId(new Date().getTime());
		seatHoldMap.put(1, 20); // Since 20 choosen for testing which is less
								// than 1250 i.e no of seats at venue level 1
		seathold.setSeatHoldMap(seatHoldMap);

		seathold.setHoldmsg("Success!!");
		seatHoldUpdated.put(1, 1250 - 20);// It will decrease level 1 seat
											// capacity by 20 seats
		seathold.setSeatHoldUpdated(seatHoldUpdated);

	}

	@After
	public void AfterExec() {

		System.out.println("FINISHED SEARCH");
	}

	@Test
	public void Test() {
		SeatHold st = o.findAndHoldSeats(20, 1, 1, "shakya.suraj07@gmail.com");

		assertEquals(st.getSeatHoldUpdated(), seatHoldUpdated);
		assertEquals(st.getCustomerEmail(), "shakya.suraj07@gmail.com");
		assertEquals(st.getSeatHoldId(), new Date().getTime());
	}

	@Test
	public void ReservationTest() {
		String expected = "Res"+Long.toString(seathold.getSeatHoldId()).substring(9,13);
		reservationCode = o.reserveSeats(seathold.getSeatHoldId(), "shakya.suraj07@gmail.com", seathold);
		assertEquals(reservationCode,expected);
	}

}
