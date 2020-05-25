import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

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
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < data.size(); i++) {
			if (min > data.get(i)) {
				min = data.get(i);
			}
		}
		System.out.println("Mininum Value:" + min);
	}

	private static void findMaxValue() {
		// TODO Auto-generated method stub
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < data.size(); i++) {
			if (max < data.get(i)) {
				max = data.get(i);
			}
		}
		System.out.println("Maximum Value:" + max);
	}

	private static void findMode() {
		// TODO Auto-generated method stub
		HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
		for (Integer integer : data) {
			if (hashMap.containsKey(integer)) {
				hashMap.put(integer, (int) hashMap.get(integer) + 1);
			} else
				hashMap.put(integer, 1);
		}

		Comparator<Entry<Integer, Integer>> valueComparator = new Comparator<Entry<Integer, Integer>>() {
			@Override
			public int compare(Entry<Integer, Integer> e1, Entry<Integer, Integer> e2) {
				Integer v1 = e1.getValue();
				Integer v2 = e2.getValue();
				return v2.compareTo(v1);
			}
		};

		List<Entry<Integer, Integer>> listOfEntries = new ArrayList<Entry<Integer, Integer>>(hashMap.entrySet());
		Collections.sort(listOfEntries, valueComparator);
		LinkedHashMap<Integer, Integer> sortedByValue = new LinkedHashMap<Integer, Integer>(listOfEntries.size());
		for (Entry<Integer, Integer> entry : listOfEntries) {
			sortedByValue.put(entry.getKey(), entry.getValue());
		}
		int highestFrequency = sortedByValue.get(listOfEntries.get(0).getKey());
		int lowestFrequency = sortedByValue.get(listOfEntries.get(listOfEntries.size() - 1).getKey());
		if (highestFrequency == lowestFrequency) {
			System.out.println("0");
		}
		Set<Entry<Integer, Integer>> entrySetSortedByValue = sortedByValue.entrySet();
		String output = "";
		for (Entry<Integer, Integer> mapping : entrySetSortedByValue) {
			if (mapping.getValue() == highestFrequency)
				output = output.concat(mapping.getKey() + ",");
		}
		System.out.println("Mode Value: " + output.substring(0, output.length() - 1));
	}

	private static void findMedian() {
		// TODO Auto-generated method stub
		Collections.sort(data);
		if (data.size() % 2 == 0) {
			System.out.println("Median Value: " + (data.get(data.size() / 2) + data.get((data.size() / 2) - 1) / 2));
		} else {
			System.out.println("Median Value: " + data.get(data.size() / 2));
		}
	}

	private static void findMean() {
		// TODO Auto-generated method stub
		int mean = 0;
		for (int i = 0; i < data.size(); i++) {
			mean += data.get(i);
		}
		System.out.println("Mean Value:" + (mean / data.size()));
	}

	private static void findSampleStandardDeviation() {
		// TODO Auto-generated method stub
		int mean = 0;
		for (int i = 0; i < data.size(); i++) {
			mean += data.get(i);
		}
		float meanvalue=(mean / data.size());
		float absolute_mean=0;
		float absolute;
		for (int i = 0; i < data.size(); i++) 
		{
			absolute=(data.get(i)-meanvalue);
			if(absolute<0)
			{
				absolute=absolute*(-1);
			}
			absolute_mean+=absolute;
		}
		
		System.out.println("Mean Absolute Deviation:" + (absolute_mean/data.size()));
	}

	

	private static void findPopulationStandardDeviation() {
		// TODO Auto-generated method stub

	}

	public static void generateData(int option) {
		switch (option) {
		case 1:
			System.out.print("Enter file name with its location:");
			String fileName = input.next();
			File file = new File(fileName);
			try {
				BufferedReader br = new BufferedReader(new FileReader(file));
				String a;
				while ((a = br.readLine()) != null)
					System.out.println(a);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();

			}

			break;

		case 2:
			Random rand = new Random();
			int upperbound = 1000;
			int i = 0;
			while (i < upperbound) {
				data.add(rand.nextInt(upperbound));
				i++;
			}
			System.out.println(data);
			break;
		}
	}

	public static void main(String[] args) {
		MainMenu obj = new MainMenu();

	}

}
