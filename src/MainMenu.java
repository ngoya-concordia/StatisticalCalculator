import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class MainMenu {
	static Scanner input = new Scanner(System.in);
	static ArrayList<Integer> data = new ArrayList<Integer>();  

	public MainMenu() {
		try {
			int userSelection = displayMainMenu();
			int option;
			while (userSelection != 3) {
				generateData(userSelection);
                option = displayOption();
				while (option != 8) {
				performOperation(option);
				System.out.println("\n\n\n---------------Continue------------------");
				option = displayOption();
				}
				System.out.println("\n\n\n---------------Continue------------------");
				userSelection = displayMainMenu();
			}
			System.out.println("\n\n--------------EXIT THE SYSTEM----------------");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Display menu to the user
	 * 
	 * @return
	 */
	private int displayMainMenu() {
		System.out.println("--------------------------------");
		System.out.println("|WELCOME TO THE SYSTEM . Please choose what would you like to do|");
		System.out.println("--------------------------------");
		System.out.println("(1) Read a file/Load the data.");
		System.out.println("(2) Generate random data");
		System.out.println("(3) Exit the process.");
		System.out.print("Please provide your input from 1 to 3 : ");
		return input.nextInt();
	}

	/**
	 * Display menu to the user
	 * 
	 * @return
	 */
	private int displayOption() {
		System.out.println("--------------------------------");
		System.out.println("Please choose your operation");
		System.out.println("--------------------------------");
		System.out.println("(1) Find Minimum value of the data.");
		System.out.println("(2) Find Maximum value of the data");
		System.out.println("(3) Find Mean of the data");
		System.out.println("(4) Find Median of the data");
		System.out.println("(5) Find Mode of the data");
		System.out.println("(6) Find Sample Standard Deviation of the data");
		System.out.println("(7) Find Population Standard Deviation of the data");
		System.out.println("(8) Exit");
		return input.nextInt();
	}

	public static void performOperation(int option) {
		switch (option) {
		case 1:
			findMinValue();
			break;
		case 2:
			findMaxValue();
			break;

		case 3:
			findMean();
			break;

		case 4:
			findMedian();
			break;

		case 5:
			findMode();
			break;

		case 6:
			findSampleStandardDeviation();
			break;
		case 7:
			findPopulationStandardDeviation();
			break;
		default:
			break;
		}
	}

	private static void findMinValue() {
		// TODO Auto-generated method stub

	}

	private static void findMaxValue() {
		// TODO Auto-generated method stub

	}

	private static void findMode() {
		// TODO Auto-generated method stub

	}

	private static void findMedian() {
		// TODO Auto-generated method stub

	}

	private static void findMean() {
		// TODO Auto-generated method stub

	}

	private static void findSampleStandardDeviation() {
		// TODO Auto-generated method stub

	}

	private static void findPopulationStandardDeviation() {
		// TODO Auto-generated method stub

	}

	public static void generateData(int option) {
	  switch(option) {
	    case 1:
	    {
	      System.out.print("Enter file name with its location:");
	      String fileName=input.next();
	      File file = new File(fileName); 
	      try {
	        BufferedReader br = new BufferedReader(new FileReader(file)); 
	        String a; 
	        while ((a = br.readLine()) != null) 
	            System.out.println(a);
	      }catch (Exception e) {
            // TODO: handle exception
	        e.printStackTrace();;
          }
	      
        }
	       
	    case 2:{
	      Random rand = new Random();
	      int upperbound = 1000;
	      int i=0;
	      while(i<upperbound) {
	        data.add(rand.nextInt(upperbound));
	        i++;
	      }
//	      System.out.println(data);
	      }
	    }
	}

	public static void main(String[] args) {
		MainMenu obj = new MainMenu();

	}

}
