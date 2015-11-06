package com.walmart.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import com.walmart.dao.*;
import com.walmart.domain.Seat;
import com.walmart.domain.SeatHold;

public class TicketServiceImpl implements TicketService {

	SeatData seatdata = new SeatDataImpl();
	SeatHold seathold;
	public static Map<Integer, Integer> UpdatedMap;
	public static int t = 0;

	public static Map<Integer, Integer> getUpdatedSeats() {
		return updatedSeats;
	}

	public static void setUpdatedSeats(Map<Integer, Integer> updatedSeats) {
		TicketServiceImpl.updatedSeats = updatedSeats;
	}

	public static Map<Integer, Integer> updatedSeats = null;

	public SeatHold getSeathold() {
		return seathold;
	}

	public void setSeathold(SeatHold seathold) {
		this.seathold = seathold;
	}

	int totalSeatAvailable = 0;
	Map<Integer, Integer> seatHoldMap = new HashMap<Integer, Integer>();
	Map<Integer, Integer> seatHoldUpdated = new HashMap<Integer, Integer>();

	/**
	 * The number of seats in the requested level that are neither held nor
	 * reserved
	 * 
	 * @param venueLevel
	 *            a numeric venue level identifier to limit the search
	 * @return the number of tickets available on the provided level
	 */

	public int numSeatsAvailable(int venueLevel) {
		// TODO Auto-generated method stub

		Seat seat = seatdata.load().get(venueLevel);
		int totalSeats = seat.getRows() * seat.getSeatInRow();

		return totalSeats;
	}
	/**
	 * This function find the Best available Seats From range of venue Level  and Holds the available seats suggested
	 * System will hold the seats for 60 seconds.If the hold seats are not reserved within 60 second , It will get expired and won't be 
	 * available for Reservation
	 * @param Number of Seats
	 * @param min venue Level  
	 * @param max venue Level
	 * @param Customer Email
	 * @return SeatHold Object contains information of Seats that are hold  and update the Seats available
	 * 
	 */

	public SeatHold findAndHoldSeats(int numSeats, int minLevel, int maxLevel,
			String customerEmail) {
		SeatHold seathold = new SeatHold();
		Map<Integer, Integer> seat = new HashMap<Integer, Integer>();
		if (t == 0)
			seat = seatdata.AvailableSeats("N", null);
		else
			seat = UpdatedMap;
		for (int i = minLevel; i <= maxLevel; i++) {

			if (numSeats <= seat.get(i)) {

				seatHoldMap.put(i, numSeats);
				seatHoldUpdated.put(i, seat.get(i) - numSeats);
				break;
			} else {
				seatHoldMap.put(i, seat.get(i));
				seatHoldUpdated.put(i, numSeats - seat.get(i));
				numSeats = numSeats - seat.get(i);

			}

			totalSeatAvailable += seat.get(i);
		}
		/**
		 * To check whether the no of seats request for hold is available or not
		 */
		// if(numSeats > totalSeatAvailable){
		//
		// seathold.setHoldmsg("Entered no. of seats are not available.");
		//
		// }else{

		seathold.setSeatHoldId(new Date().getTime());
		seathold.setCustomerEmail(customerEmail);
		seathold.setSeatHoldMap(seatHoldMap);
		seathold.setHoldmsg("Success!!");
		seathold.setSeatHoldUpdated(seatHoldUpdated);
		UpdatedMap = UpdateSeats(seathold);
		// }

		this.setSeathold(seathold);
		t++;
		return seathold;
	}
	
/**
 * This function reserves or commits the hold number of seat 
 * @param SeatHoldId 
 * @param Customer Email
 * @param SeatHold Object
 * @return Message with Reservation Code  otherwise failure Message
 * 
 */
	public String reserveSeats(long seatHoldId, String customerEmail,
			SeatHold seathold) {

		String msg = "";
		if (seathold != null) {

			if (seathold.getSeatHoldId() == seatHoldId
					&& seathold.getCustomerEmail().equals(customerEmail)) {

				Map<Integer, Integer> updated = seatdata.AvailableSeats("U",
						seathold.getSeatHoldUpdated());
				msg = "Res"+ Long.toString(seathold.getSeatHoldId()).substring(9,
								13);
				SendEmail(customerEmail, msg);

			}

		} else {
			msg = "We are Sorry! Reservation cannot be made at this time.Please Enter your detail correctly!";
		}

		return msg;
	}
    /**
     * 
     * This function update the Collection of seats available
     * @param seathold
     * @return updated Collection of Seats
     */
	public Map<Integer, Integer> UpdateSeats(SeatHold seathold) {

		Map<Integer, Integer> updated = seatdata.AvailableSeats("U",
				seathold.getSeatHoldUpdated());
		return updated;
	}

	public void SendEmail(String email, String resCode) {

		String to = email;
		String subject = "Reservation Confirmed!";
		String body = "<p>Dear " + email + ",</p>";
		body += "Your Reservation has been done.Your Reservation Code is "
				+ resCode;
		body += "<p>Regards<br/>" + "WalMart Theatre</p>";
		AppMailer appmail = new AppMailer();
		appmail.sendEmail(to, subject, body);

	}

}