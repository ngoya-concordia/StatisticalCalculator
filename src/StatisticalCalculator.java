
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 * This class is defined for the GUI for the statistical calculator
 * 
 * @author Team D
 */
class StatisticalCalculator extends JFrame implements ActionListener {
	/** width of the Main window */
	private static final int FRAME_WIDTH = 450;
	/** height of the Main window */
	private static final int FRAME_HEIGHT = 450;
	/** x-coordinate of the Main Window */
	private static final int FRAME_X = 150;
	/** y-coordinate of the Main Window */
	private static final int FRAME_Y = 100;
	/**   */
	private JPanel buttonPanel;
	private JPanel dataPanel;
	private JPanel inputOutputPanel;

	private JTextField info;

	private boolean editable = true;

	MainController obj = null;

	/**
	 * This method adds the output view of the calculator.
	 */
	void addOutputView() {
		inputOutputPanel = new JPanel();
		inputOutputPanel.setLayout(new FlowLayout());

		inputOutputPanel.setBorder(new EmptyBorder(10, 5, 5, 5));

		setTitle("Statistical Calculator");
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setResizable(false);
		setLocation(FRAME_X, FRAME_Y);

		info = new JTextField();
		info.setFont(new Font("SansSerif", Font.PLAIN, 16));
		info.setBackground(Color.white);
		info.setBorder(BorderFactory.createLineBorder(Color.black));
		info.setPreferredSize(new Dimension(300, 35));
		info.setEditable(false);
		info.setFocusable(false);
		info.addActionListener(this);
		inputOutputPanel.add(info);

	}

	/**
	 * This method displays the buttons where the user can select the generate
	 * random data, upload data from an existing file and clear data.
	 */
	void addInputDataViews() {

		String dataButtons[] = { "Generate Random", "Upload Data", "Clear" };
		dataPanel = new JPanel();
		dataPanel.setLayout(new GridLayout(1, 3, 5, 5));
		dataPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

		// adding special buttons for buttons array
		for (String i : dataButtons) {
			JButton button = new JButton(i);
			button.setPreferredSize(new Dimension(110, 30));
			button.addActionListener(this);
			dataPanel.add(button);
		}

	}

	/**
	 * This method displays the buttons which displays the several operations that
	 * need to be performed on the data set
	 */

	void addCalculatorButtons() {
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(6, 4, 5, 5));
		buttonPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

		String buttons[] = { "Min", "Max", "Mean", "Median", "Mode", "Mean Abs Dev", "Std Dev", "Variance", "7", "8",
				"9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "0", ".", "=", "+", };

		for (String i : buttons) {
			JButton button = new JButton(i);
			button.setMargin(new Insets(2, 2, 2, 2));
			button.setPreferredSize(new Dimension(80, 40));
			button.addActionListener(this);
			button.setFocusable(false);
			buttonPanel.add(button);
		}

	}

	/**
	 * This methods adds the main window screen.
	 */
	void addMainWindow() {
		Container contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		addOutputView();
		addInputDataViews();
		addCalculatorButtons();
		contentPane.add(inputOutputPanel);
		contentPane.add(dataPanel);
		contentPane.add(buttonPanel);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	/**
	 * Initializes the Statistical Calculator.
	 */
	public StatisticalCalculator() {
		obj = new MainController();
		addMainWindow();
	}

	/**
	 * This method displays the buttons of the several operations and displays the
	 * values on the GUI when certain operations are selected else it will take
	 * input from the text file and the output is displayed on the text field
	 */

	public void actionPerformed(ActionEvent event) {
		// source is from button
		if (event.getSource() instanceof JButton) {
			JButton clickedButton = (JButton) event.getSource();
			// if = is clicked then result will be displayed
			if (clickedButton.getText().equals("=")) {
				addOutput();
			} else if (clickedButton.getText().equalsIgnoreCase("Generate Random")) {
				obj.generateRandomData();
				info.setText("Random Data has been generated!");
			} else if (clickedButton.getText().equalsIgnoreCase("Upload Data")) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
				int result = fileChooser.showOpenDialog(this);
				if (result == JFileChooser.APPROVE_OPTION) {
					File selectedFile = fileChooser.getSelectedFile();
					obj.loadData(selectedFile);
					System.out.println("Selected file: " + selectedFile.getAbsolutePath());
				}

				info.setText("Data has been loaded successfully!");
			} else if (clickedButton.getText().equalsIgnoreCase("Clear")) {
				info.setText("");
			} else if (clickedButton.getText().equalsIgnoreCase("Min")) {
				int min = obj.findMinValue();
				printResult(String.valueOf(min));
			} else if (clickedButton.getText().equalsIgnoreCase("Max")) {
				int max = obj.findMaxValue();
				printResult(String.valueOf(max));
			} else if (clickedButton.getText().equalsIgnoreCase("Mean")) {
				double mean = obj.findMean();
				printResult(String.valueOf(mean));
			} else if (clickedButton.getText().equalsIgnoreCase("Median")) {
				double median = obj.findMedian();
				printResult(String.valueOf(median));
			} else if (clickedButton.getText().equalsIgnoreCase("Mode")) {
				String mode = obj.findMode();
				printResult(String.valueOf(mode));
			} else if (clickedButton.getText().equalsIgnoreCase("Mean Abs Dev")) {
				double meanAbsDev = obj.findStandardDeviation();
				printResult(String.valueOf(meanAbsDev));
			} else if (clickedButton.getText().equalsIgnoreCase("Std Dev")) {
				double stdDev = obj.findMeanAbsoluteDeviation();
				printResult(String.valueOf(stdDev));
			} else if (clickedButton.getText().equalsIgnoreCase("Variance")) {
				double var = obj.findVariance();
				printResult(String.valueOf(var));
			}
			// else we will take input
			else {
				addInput(clickedButton.getText());
			}
		}
		// source is from JTextField
		else {
			addOutput();
		}
	}

	/**
	 * This method displays the output when the editable is false and there wouldn't
	 * be any appending, the text will be added manually
	 * 
	 * @param String data that needs to be displayed.
	 */
	public void addInput(String line) {
		if (editable) {
			info.setText(info.getText() + line);
		} else {
			info.setText(line);
			editable = true;
		}
	}

	/**
	 * This method converts the string into an expression and computes the output.
	 */

	public void addOutput() {
		double output = 0;

		try {
			ScriptEngineManager mgr = new ScriptEngineManager();
			ScriptEngine engine = mgr.getEngineByName("JavaScript");
			info.setText(engine.eval(info.getText()).toString());
		} catch (ScriptException e) {
			info.setText("Syntax error");
		}
		editable = false;
	}

	/**
	 * This method converts the string into an expression and computes the output
	 * 
	 * @param val can be evaluated to compute the result.
	 */
	public void printResult(String val) {
		try {
			ScriptEngineManager mgr = new ScriptEngineManager();
			ScriptEngine engine = mgr.getEngineByName("JavaScript");
			info.setText(engine.eval(val).toString());
		} catch (ScriptException e) {
			info.setText("Syntax error");
		}
		editable = false;
	}

	/**
	 * This is the main method
	 */

	public static void main(String[] args) {
		StatisticalCalculator calculator = new StatisticalCalculator();
		calculator.setVisible(true);
	}
}
