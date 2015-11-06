package com.walmart.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.walmart.domain.SeatHold;

import com.walmart.service.TicketServiceImpl;

public class ActionFactory extends TimerTask {
	

	public static String[] level = {
		                              ""
		                              ,"Orchestra"
		                              ,"Main"
		                              ,"Balcony 1"
		                              ,"Balcony 2"
	                                };
	Timer timer;
	public static SeatHold seathold;
	public static Map<Integer, Integer> HoldMap;
	public static Map<Integer, Integer> UpdatedMap;
	static int t = 0;
	String ch = "Y";
	public static boolean isReserved = false;
	private TicketServiceImpl service = new TicketServiceImpl();

	/**
	 * 
	 * 
	 * @return boolean
	 * @param String
	 *            Email
	 */
	public boolean validateEmail(String email) {

		Pattern p = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		Matcher m = p.matcher(email);
		// Matcher m=p.matcher(args[0]);
		boolean b = m.matches();

		return b;
	}

	public void getAction(int action) throws Exception {

		
		ActionFactory actionObj = new ActionFactory();
		if (action == 1) {
			int noOfSeats;
			do {
				try {
					System.out.println("Please Enter the Venue Level[1-4]:");
					BufferedReader br = new BufferedReader(
							new InputStreamReader(System.in));
					int venuelevel = Integer.parseInt(br.readLine());
					if (t == 0)
						noOfSeats = new TicketServiceImpl()
								.numSeatsAvailable(venuelevel);
					else {

						noOfSeats = UpdatedMap.get(venuelevel);

					}

					System.out.println("The total no of Seats Available on "
							+ level[venuelevel] + " Level is:" + noOfSeats);
					System.out.println("Continue with Search? Y /N");
					BufferedReader br1 = new BufferedReader(
							new InputStreamReader(System.in));
					ch = br1.readLine();
					
					isReserved= true;
				} catch (NumberFormatException e) {

					System.err.println("Please Enter the Required Field.\n");
				}

			} while (ch.equalsIgnoreCase("Y"));

		}
		if (action == 2) {
			try {
				System.out.println("Please Enter the No of seats to Hold:");
				BufferedReader br = new BufferedReader(new InputStreamReader(
						System.in));
				int noOfSeats = Integer.parseInt(br.readLine());
				System.out.print("Please enter min Level:");
				BufferedReader br1 = new BufferedReader(new InputStreamReader(
						System.in));
				int minlevel = Integer.parseInt(br1.readLine());
				System.out.print("Please enter max Level:");
				BufferedReader br2 = new BufferedReader(new InputStreamReader(
						System.in));
				int maxlevel = Integer.parseInt(br2.readLine());
				
				System.out.print("Please enter the Email:");
				
				BufferedReader br3 = new BufferedReader(new InputStreamReader(
						System.in));
				String email = br3.readLine();
                boolean b  = actionObj.validateEmail(email);
				
                if(b==false)
                	throw new Exception("Invalid Email");
                

				seathold = service.findAndHoldSeats(noOfSeats, minlevel,
						maxlevel, email);
				// HoldMap = seathold.getSeatHoldUpdated();
				UpdatedMap = service.UpdateSeats(seathold);
				t++;
//				System.out.println(UpdatedMap);
				System.out.println("------The number of seat Hold are as follows-----\n ");
						
				for (Map.Entry<Integer, Integer> entry : seathold.getSeatHoldMap().entrySet()) {
				    Integer key = entry.getKey();
				    Integer value = entry.getValue();
				  System.out.println( level[key] +":"+value);
			    	}
				System.out.println("The Seat Hold Id is "
						+ seathold.getSeatHoldId());
				System.out.println("Please confirm the reservation within 60 seconds after you hold the Seats!!!\n ");
			} catch (NumberFormatException e) {
				System.err.println("Please Enter the Required Field.");
			}

		}

		if (action == 3) {
			System.out
					.println("Please Enter the SeatHold Id for Reservation confirmation");
			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));
			long holdId = Long.parseLong(br.readLine());
			System.out.println("Please Enter your Email");
			BufferedReader br1 = new BufferedReader(new InputStreamReader(
					System.in));
			String customerEmail = br1.readLine();
			
			isReserved= true;
			//time.purge();
			String reservationCode = service.reserveSeats(holdId,
					customerEmail, seathold);
			
			String message = "Reservation Confirmed!\n Your Reservation has been done.Your Reservation Code is "+reservationCode+"\n Thank you!";
			
			System.err.println(message);
			for (Map.Entry<Integer, Integer> entry : seathold.getSeatHoldMap().entrySet()) {
			    Integer key = entry.getKey();
			    Integer value = entry.getValue();
			  System.err.println( level[key] +":"+value);
		    	}
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		if(!isReserved){
			
		seathold = null;
		UpdatedMap = null;
		t = 0;
		System.err.println("The Hold seats have been expired!!");
		//timer.cancel();
		}
		
		isReserved = false;
		
	}
}