
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

class StatisticalCalculator extends JFrame implements ActionListener
{
    private static final int FRAME_WIDTH = 550;
    private static final int FRAME_HEIGHT = 400;
    private static final int FRAME_X = 150;
    private static final int FRAME_Y = 100;

    private JPanel buttonPanel;
    private JPanel spclButtonPanel;
    private JPanel inputOutputPanel;

    private JTextField info;

    private boolean editable = true;
    
    MainController obj =null;

    public StatisticalCalculator()
    {
    	 obj = new MainController();
        Container contentPane = getContentPane();
        contentPane.setLayout(new FlowLayout());

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(6,6,6,6));
        //for padding
        buttonPanel.setBorder(new EmptyBorder(10,10,10,10));
        
        spclButtonPanel = new JPanel();
        spclButtonPanel.setLayout(new GridLayout(1,1,1,1));
        //for padding
        spclButtonPanel.setBorder(new EmptyBorder(10,10,10,10));

        inputOutputPanel = new JPanel();
        inputOutputPanel.setLayout(new FlowLayout());
        //for padding
        inputOutputPanel.setBorder(new EmptyBorder(10,10,10,10));

        setTitle("Statistical Calculator");
        setSize(FRAME_WIDTH,FRAME_HEIGHT);
        setResizable(false);
        setLocation(FRAME_X,FRAME_Y);

        info = new JTextField();
        info.setFont(new Font("SansSerif", Font.PLAIN, 16));
        info.setBackground(Color.white);
        info.setBorder(BorderFactory.createLineBorder(Color.black));
        info.setPreferredSize(new Dimension(270, 35));
        info.addActionListener(this);
        inputOutputPanel.add(info);
        contentPane.add(inputOutputPanel);

        //buttons in calculator
        String buttons[] = {"Min", "Max", "Mean", "Median","Mode", "Mean Abs Dev", "Std Dev", "Variance","7", "8", "9", "/", "4", "5", "6", "*", "1", "2","3","-","0",".","=", "+",};
        String spclButtons[] = {"Generate Random",  "Upload Data"};

        //adding special buttons for buttons array
        for (String i : spclButtons)
        {
        	JButton button = new JButton(i);
        	button.addActionListener(this);
        	spclButtonPanel.add(button);
        }
        
        contentPane.add(spclButtonPanel);
        
        //adding buttons for buttons array
        for (String i : buttons)
        {
            JButton button = new JButton(i);
            button.addActionListener(this);
            buttonPanel.add(button);
        }

        contentPane.add(buttonPanel);
        
        

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent event)
    {
        //source is from button
        if (event.getSource() instanceof JButton)
        {
            JButton clickedButton = (JButton) event.getSource();
            //if = is clicked then result will be displayed
            if(clickedButton.getText().equals("="))
            {
                addOutput();
            }
            else if(clickedButton.getText().equalsIgnoreCase("Generate Random"))
            {
            	obj.generateData();
            }
            else if(clickedButton.getText().equalsIgnoreCase("Upload Data"))
            {
            	obj.loadData();
            }
            else if(clickedButton.getText().equalsIgnoreCase("Min"))
            {
            	int min =obj.findMinValue();
            	printResult(String.valueOf(min));
            }
            else if(clickedButton.getText().equalsIgnoreCase("Max"))
            {
            	int max= obj.findMaxValue();
            	printResult(String.valueOf(max));
            }
            else if(clickedButton.getText().equalsIgnoreCase("Mean"))
            {
            	double mean = obj.findMean();
            	printResult(String.valueOf(mean));
            }
            else if(clickedButton.getText().equalsIgnoreCase("Median"))
            {
            	double median = obj.findMedian();
            	printResult(String.valueOf(median));
            }
            else if(clickedButton.getText().equalsIgnoreCase("Mode"))
            {
            	String mode = obj.findMode();
            	printResult(String.valueOf(mode));
            }
            else if(clickedButton.getText().equalsIgnoreCase("Mean Abs Dev"))
            {
            	double meanAbsDev = obj.findPopulationStandardDeviation();
            	printResult(String.valueOf(meanAbsDev));
            }
            else if(clickedButton.getText().equalsIgnoreCase("Std Dev"))
            {
            	double stdDev = obj.findSampleStandardDeviation();
            	printResult(String.valueOf(stdDev));
            }
            else if(clickedButton.getText().equalsIgnoreCase("Variance"))
            {
            	double var = obj.findVariance();
            	printResult(String.valueOf(var));
            }
            //else we will take input
            else
            {
                addInput(clickedButton.getText());
            }
        }
        //source is from JTextField
        else
        {
            addOutput();
        }
    }

    public void addInput(String line)
    {
        //appending pressed keys to TextField
        //editable will be false if result is displayed
        if(editable)
        {
            info.setText(info.getText()+line);
        }
        //result is on the screen
        //editable is false
        //no appending
        //we will add the text
        else
        {
            info.setText(line);
            editable = true;
        }
    }
    public void addOutput()
    {
        double output = 0;

        //converting string into expression
        try
        {
            ScriptEngineManager mgr = new ScriptEngineManager();
            ScriptEngine engine = mgr.getEngineByName("JavaScript");
            info.setText(engine.eval(info.getText()).toString());
        }
        catch(ScriptException e)
        {
            info.setText("Syntax error");
        }
        editable = false;
    }
    
    public void printResult(String val)
    {
        //converting string into expression
        try
        {
            ScriptEngineManager mgr = new ScriptEngineManager();
            ScriptEngine engine = mgr.getEngineByName("JavaScript");
            info.setText(engine.eval(val).toString());
        }
        catch(ScriptException e)
        {
            info.setText("Syntax error");
        }
        editable = false;
    }
    

    //main method
    public static void main (String [] args)
    {
    	StatisticalCalculator calculator = new StatisticalCalculator();
        calculator.setVisible(true);
    }
}
 

