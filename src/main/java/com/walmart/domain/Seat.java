package com.walmart.domain;

public class Seat {
	public int seatLevel;
	public String levelName;
	public double price;
	public int rows;
	public int seatInRow;
	public int totalSeatsInRow;
	
	public int getTotalSeatsInRow() {
		return totalSeatsInRow;
	}


	public void setTotalSeatsInRow(int totalSeatsInRow) {
		this.totalSeatsInRow = totalSeatsInRow;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public Seat(int seatLevel , String levelName , double price , int rows , int seatInRow , int totalSeatsInRow ){
		this.seatLevel = seatLevel;
		this.levelName = levelName;
		this.price = price;
		this.rows = rows;
		this.seatInRow = seatInRow;
		this.totalSeatsInRow = totalSeatsInRow;
		
	}
	public Seat(int totalSeatsInRow){
		this.totalSeatsInRow = totalSeatsInRow;
	}
	
	public int getSeatLevel() {
		return seatLevel;
	}
	public void setSeatLevel(int seatLevel) {
		this.seatLevel = seatLevel;
	}
	public String getLevelName() {
		return levelName;
	}
	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getSeatInRow() {
		return seatInRow;
	}
	public void setSeatInRow(int seatInRow) {
		this.seatInRow = seatInRow;
	}

}
