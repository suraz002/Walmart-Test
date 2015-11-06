package com.walmart.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 
 * Main Class or starting Point to execute the Ticket Service
 * 
 */
public class App {
	private static int action = 0;
	Timer timer;

	public void doInit() throws Exception {

		do {
			System.out.println("Please Choose from Menu[0-3]:");
			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));
			action = Integer.parseInt(br.readLine());

			ActionFactory factory = new ActionFactory();
			 if (action == 2) {
			Timer time = new Timer(); // Instantiate Timer Object
			time.schedule(factory, 60000); // execute Run method after 60
											// second
			}
			factory.getAction(action);

		} while (action != 0);
		{

			System.out.print("Bye Bye....");
			System.exit(0);
		}
	}

	/**
	 * Project starting point
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		App appObj = new App();
		Template tmp = new Template();
		tmp.PrintHeader();
		tmp.getMenu();

		try {
			appObj.doInit();
		} catch (NumberFormatException e) {

			System.err
					.println("Please Enter the Required Field in Proper Number format.");

		} finally {

			appObj.doInit();
		}

	}
}