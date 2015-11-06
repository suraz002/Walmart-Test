package com.walmart.domain;

import java.util.HashMap;
import java.util.Map;

public class SeatHold {
	
	public String customerEmail;
	public int seatHoldLevel;
	public String seatHoldId;
	public String holdmsg;
	public int seatHoldNo;
	public Map<Integer , Integer> seatHoldMap = null;
	public Map<Integer , Integer> seatHoldUpdated = null;
	
public Map<Integer, Integer> getSeatHoldUpdated() {
		return seatHoldUpdated;
	}
	public void setSeatHoldUpdated(Map<Integer, Integer> seatHoldUpdated) {
		this.seatHoldUpdated = seatHoldUpdated;
	}
public SeatHold(String seatHoldId,int seatHoldNo, int seatHoldLevel , String customerEmail){
		this.seatHoldId = seatHoldId;
		this.seatHoldNo = seatHoldNo;
		this.seatHoldLevel = seatHoldLevel;
		this.customerEmail = customerEmail;
	}
	public SeatHold(int seatHoldLevel, int seatHoldNo) {
		
		this.seatHoldLevel = seatHoldLevel;
		this.seatHoldNo = seatHoldNo;
		seatHoldMap = new HashMap<Integer , Integer>();
		seatHoldMap.put(seatHoldLevel, seatHoldNo);
		
    }
	public Map<Integer, Integer> getSeatHoldMap() {
		return seatHoldMap;
	}
	public void setSeatHoldMap(Map<Integer, Integer> seatHoldMap) {
		this.seatHoldMap = seatHoldMap;
	}
	public SeatHold() {
		// TODO Auto-generated constructor stub
	}
	public int getSeatHoldNo() {
		return seatHoldNo;
	}

	public void setSeatHoldNo(int seatHoldNo) {
		this.seatHoldNo = seatHoldNo;
	}

	
	
	public String getHoldmsg() {
		return holdmsg;
	}
	public void setHoldmsg(String holdmsg) {
		this.holdmsg = holdmsg;
	}
	public Map<String,Integer> SeatHold;
	
	
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public int getSeatHoldLevel() {
		return seatHoldLevel;
	}
	public void setSeatHoldLevel(int seatHoldLevel) {
		this.seatHoldLevel = seatHoldLevel;
	}
	public String getSeatHoldId() {
		return seatHoldId;
	}
	public void setSeatHoldId(String seatHoldId) {
		this.seatHoldId = seatHoldId;
	}
	public Map<String, Integer> getSeatHold() {
		return SeatHold;
	}
	public void setSeatHold(Map<String, Integer> seatHold) {
		SeatHold = seatHold;
	}
	
	
	

}
