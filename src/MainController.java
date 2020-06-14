import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
/**
 * This is the  Main controller class which has all the operations that needs to be performed on the given data set
 * @author  Rohit, Aman, Nancy, Chitra, Shabnam and Akhila
 */
public class MainController implements IOperations, IGenerateLoadData {
	static Scanner input = new Scanner(System.in);
	static ArrayList<Integer> data = new ArrayList<Integer>();

	public MainController() {

	}

	public void performOperation(int option) {
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
			findMeanAbsoluteDeviation();
			break;
		case 7:
			findStandardDeviation();
			break;
		case 8:
			findVariance();
		default:
			break;
		}
	}
/**
 * This method returns the maximum value of the given data set
 * @author Aman
 */
	public int findMinValue() {
		
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < data.size(); i++) {
			if (min > data.get(i)) {
				min = data.get(i);
			}
		}
		System.out.println("Mininum Value:" + min);
		return min;
	}
	/**
	 * This method returns the minimum value of the given data set
	 * @author Aman
	 */

	public int findMaxValue() {
		
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < data.size(); i++) {
			if (max < data.get(i)) {
				max = data.get(i);
			}
		}
		System.out.println("Maximum Value:" + max);
		return max;
	}
	/**
	 * This method returns the mode value of the given data set
	 * @author  Rohit
	 */
	public String findMode() {
		
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

		return output.substring(0, output.length() - 1);
	}
	/**
	 * This method returns the median value of the given data set
	 * @author  Rohit, Aman
	 */
	public double findMedian() {
		
		Collections.sort(data);
		double median;
		if ((data.size() % 2) != 0) {
			median = (double) data.get(data.size() / 2);

		} else {
			median = (double) ((data.get((data.size() / 2) - 1) + (data.get(data.size() / 2))) / 2.0);
		}
		System.out.println("Median Value: " + median);
		return median;
	}
	/**
	 * This method returns the mean value of the given data set
	 * @author  Rohit, Aman
	 */
	public double findMean() {
		// TODO Auto-generated method stub
		double mean = 0;
		double meanvalue = 0;
		for (int i = 0; i < data.size(); i++) {
			mean += data.get(i);
		}
		meanvalue = mean / data.size();
		System.out.println("Mean Value:" + meanvalue);
		meanvalue = (long)(meanvalue * 100000)/100000.0;
		return meanvalue;
	}
	/**
	 * This method returns the Mean absolute deviation value of the given data set
	 * @author Chitra
	 */
	public double findMeanAbsoluteDeviation() {
	
		double meanvalue = findMean();
		double absolute_mean = 0;
		double absolute;
		for (int i = 0; i < data.size(); i++) {
			absolute = (data.get(i) - meanvalue);
			if (absolute < 0) {
				absolute = absolute * (-1);
			}
			absolute_mean += absolute;
		}

		System.out.println("Mean Absolute Deviation:" + (absolute_mean / data.size()));
		absolute_mean = absolute_mean / data.size();
		absolute_mean = (long)(absolute_mean * 100000)/100000.0;
		return absolute_mean;
	}
	/**
	 * This method returns the square value of the given data set
	 * @author Shabnam
	 * @param a It is a numerical value
	 *  
	 */
	public double square(double a) {
		return a * a;
	}
	/**
	 * This method returns the square root value of the given data set
	 * @author  Shabnam
	 * @param a It is an numerical value
	 */
	public double square_root(double a) {
		double temp;
		double sqrt = a / 2;
		do {
			temp = sqrt;
			sqrt = (temp + (a / temp)) / 2;
		} while ((temp - sqrt) != 0);
		return sqrt;
	}
	/**
	 * This method returns the Standard deviation value of the given data set
	 * @author Shabnam, Chitra
	 */
	public double findStandardDeviation() {
		double meanvalue = findMean();
		double standard_deviation = 0;
		for (int i = 0; i < data.size(); i++)
			standard_deviation += square(data.get(i) - meanvalue);
		standard_deviation = standard_deviation / data.size();
		System.out.println("Standard Deviation:" + square_root(standard_deviation));
		standard_deviation = square_root(standard_deviation);
		standard_deviation = (long)(standard_deviation * 100000) / 100000.0;
		return standard_deviation;
	}
	/**
	 * This method gives us the random values for all the operations that needs to be performed
	 * @author Rohit, Aman, Nancy
	 */
	public void generateRandomData() {

		Random rand = new Random();
		int upperbound = 1000;
		int i = 0;
		while (i < upperbound) {
			data.add(rand.nextInt(upperbound));
			i++;
		}
		System.out.println(data);
		try {
	      FileWriter myWriter = new FileWriter("RandomData.txt");
	      myWriter.write(String.valueOf(data));
	      myWriter.close();
	    } catch (IOException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
	}
	/** 
	 * This method loads the data from the text file when the user wants to compute the operations on the existing data set 
	 * @author Rohit, Aman, Nancy
	 */
	public void loadData() {

		System.out.print("Please keep the file in project and enter the name");
		String fileName = input.next();
		File file = new File("./" + fileName);
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String a;
			while ((a = br.readLine()) != null) {
				System.out.println(a);
				Integer value = Integer.parseInt(a);
				data.add(value);
			}
		} catch (Exception e) {
			// handles the exception
			e.printStackTrace();

		}

	}
	/**
	 * This method returns the variance of the given data set
	 * @author  Akhila 
	 */
	public double findVariance() {
		double mean = findMean();
		double sd = 0;
		for (int j = 0; j < data.size(); j++)
			sd += (data.get(j) - mean) * (data.get(j) - mean);
		System.out.println("Variance:" + (double) sd / data.size());
		sd= (double) sd / data.size();
		sd = ((long)(sd * 100000)) /100000.0;
		return sd;

	}

}
