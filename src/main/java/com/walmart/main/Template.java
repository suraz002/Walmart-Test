package com.walmart.main;

public class Template {
	
	void PrintHeader(){
		System.out.println("----------------------------------------------");
		System.out.println("|       Welcome to Walmart Ticket Service    |");
		System.out.println("----------------------------------------------");
	}
	
    void  getMenu(){
    	
    	System.out.println("Choose  Menu Below");
    	System.out.println("[1] Find the number Seats Available.");
		System.out.println("[2] Find and hold the available seats.");
		System.out.println("[3] Reserve the Hold seats.");
		System.out.println("[0] Exit");
		
    }
}
