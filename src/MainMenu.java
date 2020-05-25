import java.util.Scanner;

public class MainMenu {
	Scanner input = new Scanner(System.in);

	public MainMenu() {
	try {
			int userSelection = displayMainMenu();
			int option;
			while (userSelection != 3) {
				option = displayOption();
				generateData(userSelection);
				while (option != 7) {
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
		System.out.println("(3) Find Mode of the data");
		System.out.println("(4) Find Median of the data");
		System.out.println("(5) Find Mean of the data");
		System.out.println("(6) Find Standard Deviation of the data");
		System.out.println("(7) Exit");
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
			findMode();
			break;

		case 4:
			findMedian();
			break;

		case 5:
			findMean();
			break;

		case 6:
			findStandardDeviation();
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

	private static void findStandardDeviation() {
		// TODO Auto-generated method stub
		
	}

	public static void generateData(int option) {
		
	}
	
	
	
	public static void main(String[] args) {
		MainMenu obj = new MainMenu();

	}

}
