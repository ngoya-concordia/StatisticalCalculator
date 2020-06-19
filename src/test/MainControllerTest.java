package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import main.MainController;

/**
 * Test class for the Main Controller.
 * 
 * @author Team D
 *
 */
public class MainControllerTest {
	/** Initialize Main Controller */
	MainController mainController = new MainController();

	/**
	 * Set up method called before running the test methods.
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		MainController.data.add(4);
		MainController.data.add(2);
		MainController.data.add(3);
		MainController.data.add(2);

		MainController.data.add(5);
		MainController.data.add(2);
		MainController.data.add(3);
		MainController.data.add(2);
	}

	/**
	 * Test Case to evaluate the Min Value on the given set of data.
	 */
	@Test
	public void findMinValueTest() {
		assertEquals(2, mainController.findMinValue());
	}

	/**
	 * Test Case to evaluate the Min Value on the given set of data.
	 */
	@Test
	public void findMaxValueTest() {
		assertEquals(5, mainController.findMaxValue());
	}

	/**
	 * Test Case to evaluate the Mean on the given set of data. The delta of
	 * 0.000009 is used to verify the preciseness of the result till 5 decimal
	 * places.
	 */
	@Test
	public void findMeanTest() {
		assertEquals(2.875, mainController.findMean(), 0.000009);
	}

	/**
	 * Test Case to evaluate Mean Absolute Deviation on the given set of data. The
	 * delta of 0.000009 is used to verify the preciseness of the result till 5
	 * decimal places.
	 */
	@Test
	public void findMeanAbsoluteDeviationTest() {
		assertEquals(0.875, mainController.findMeanAbsoluteDeviation(), 0.000009);
	}

	/**
	 * Test Case to evaluate the Median on the given set of data. The delta of
	 * 0.000009 is used to verify the preciseness of the result till 5 decimal
	 * places.
	 */
	@Test
	public void findMedianTest() {
		assertEquals(2.5, mainController.findMedian(), 0.000009);
	}

	/**
	 * Test Case to evaluate the Standard Deviation on the given set of data. The
	 * delta of 0.000009 is used to verify the preciseness of the result till 5
	 * decimal places.
	 */
	@Test
	public void findStandardDeviationTest() {
		assertEquals(1.05326, mainController.findStandardDeviation(), 0.000009);
	}

	/**
	 * Test Case to evaluate the variance on the given set of data. The delta of
	 * 0.000009 is used to verify the preciseness of the result till 5 decimal
	 * places.
	 */
	@Test
	public void findVarianceTest() {
		assertEquals(1.10937, mainController.findVariance(), 0.000009);
	}

	/**
	 * Test Case to evaluate the Mode Value on the given set of data.
	 */
	@Test
	public void findModeTest() {
		assertEquals("2", mainController.findMode());
	}

}
