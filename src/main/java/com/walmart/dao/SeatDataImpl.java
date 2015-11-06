package com.walmart.dao;

import java.util.HashMap;
import java.util.Map;

import com.walmart.domain.Seat;
import com.walmart.domain.SeatHold;

public class SeatDataImpl implements SeatData{

	public static Map<Integer, Integer> seats;
	

	
	/**
	 * Eg.
	 * Venue Level 1 -Orchestra  -  25 rows , 50 seats in row , total Seats in Level 25*50 = 1250
	 * 
	 * @return seats HashMap
	 */
	public Map<Integer, Seat> load() {
		Map <Integer , Seat>  seats = new HashMap<Integer , Seat>();
			seats.put(1, new Seat(1,"Orchestra",100.00,25,50,50*25));
			seats.put(2, new Seat(2,"Main",75.00,20,100,20*100));
			seats.put(3, new Seat(3,"Balcony 1",50.00,15,100,15*100));
			seats.put(4, new Seat(4,"Balcony 2",40.00,15,100,15*100));
			return  seats;
			}

	public Map<Integer, Integer> AvailableSeats(String status,  Map<Integer , Integer> holdSeat) {
	  seats = new HashMap<Integer , Integer>();
	
		seats.put(1, 50*25);
		seats.put(2, 20*100);
		seats.put(3, 15*100);
		seats.put(4, 15*100);
		
		if(status.equals("U")){
		for (Map.Entry<Integer, Integer> entry : holdSeat.entrySet()) {
		    Integer key = entry.getKey();
		    Integer value = entry.getValue();
		   seats.put(key, value);
	    	}
		}
			
		
		return  seats;
	}
    
	public Map<Integer, SeatHold> HoldSeats(SeatHold seathold) {
		// TODO Auto-generated method stub
		Map<Integer , SeatHold>  seatHoldMap = new HashMap<Integer , SeatHold>();
		seatHoldMap.put(seathold.getSeatHoldLevel(), seathold);
		return seatHoldMap;
	}

	

}
