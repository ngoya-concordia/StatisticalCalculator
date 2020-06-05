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

	public int findMinValue() {
		// TODO Auto-generated method stub
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < data.size(); i++) {
			if (min > data.get(i)) {
				min = data.get(i);
			}
		}
		System.out.println("Mininum Value:" + min);
		return min;
	}

	public int findMaxValue() {
		// TODO Auto-generated method stub
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < data.size(); i++) {
			if (max < data.get(i)) {
				max = data.get(i);
			}
		}
		System.out.println("Maximum Value:" + max);
		return max;
	}

	public String findMode() {
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

		return output.substring(0, output.length() - 1);
	}

	public double findMedian() {
		// TODO Auto-generated method stub
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

	public double findMean() {
		// TODO Auto-generated method stub
		double mean = 0;
		double meanvalue = 0;
		for (int i = 0; i < data.size(); i++) {
			mean += data.get(i);
		}
		meanvalue = mean / data.size();
		System.out.println("Mean Value:" + meanvalue);
		return meanvalue;
	}

	public double findMeanAbsoluteDeviation() {
		// TODO Auto-generated method stub
		double mean = 0;
		for (int i = 0; i < data.size(); i++) {
			mean += data.get(i);
		}
		double meanvalue = (mean / data.size());
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
		return (absolute_mean / data.size());
	}

	public double square(double a) {
		return a * a;
	}

	public double square_root(double a) {
		double temp;
		double sqrt = a / 2;
		do {
			temp = sqrt;
			sqrt = (temp + (a / temp)) / 2;
		} while ((temp - sqrt) != 0);

		return sqrt;
	}

	public double findStandardDeviation() {
		double meanvalue = findMean();
		double standard_deviation = 0;
		for (int i = 0; i < data.size(); i++)
			standard_deviation += square(data.get(i) - meanvalue);
		standard_deviation = standard_deviation / data.size();
		System.out.println("Standard Deviation:" + square_root(standard_deviation));
		return square_root(standard_deviation);
	}

	public void generateRandomData() {

		Random rand = new Random();
		int upperbound = 1000;
		int i = 0;
		while (i < upperbound) {
			data.add(rand.nextInt(upperbound));
			i++;
		}
		System.out.println(data);

	}

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
			// TODO: handle exception
			e.printStackTrace();

		}

	}

	public double findVariance() {
		double mean = findMean();
		double sd = 0;
		for (int j = 0; j < data.size(); j++)
			sd += (data.get(j) - mean) * (data.get(j) - mean);
		System.out.println("Variance:" + (double) sd / data.size());
		return (double) sd / data.size();

	}

}
