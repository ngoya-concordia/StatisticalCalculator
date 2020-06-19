package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;
import main.MainController;

public class MainControllerTest  {

	MainController mainController = new MainController();

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

	@Test
	public void findMinValueTest() {
		assertEquals(2, mainController.findMinValue());
	}

	@Test
	public void findMaxValueTest() {
		assertEquals(5, mainController.findMaxValue());
	}

	@Test
	public void findMeanTest() {
		assertEquals(2.875, mainController.findMean(),0.00001);
	}

	@Test
	public void findMeanAbsoluteDeviationTest() {
		assertEquals(0.875, mainController.findMeanAbsoluteDeviation(),0.00001);
	}

	@Test
	public void findMedianTest() {
		assertEquals(2.5, mainController.findMedian(),0.00001);
	}

	@Test
	public void findStandardDeviationTest() {
		assertEquals(1.05326, mainController.findStandardDeviation(),0.00001);
	}

	@Test
	public void findVarianceTest() {
		assertEquals(1.10937, mainController.findVariance(),0.00001);
	}

	@Test
	public void findModeTest() {
		assertEquals("2", mainController.findMode());
	}

}
