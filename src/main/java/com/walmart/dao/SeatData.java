package com.walmart.dao;

import java.util.Map;

import com.walmart.domain.Seat;

public interface SeatData {
	/**
	 * This function will load the Seat in collection for first time
	 * 
	 * @return Collection with Seats loaded
	 */
	public Map<Integer, Seat> load();

	/**
	 * 
	 * @param status
	 * @param map
	 * @return Map with Updated Collection of seats
	 */
	public Map<Integer, Integer> AvailableSeats(String status,
			Map<Integer, Integer> map);

}
