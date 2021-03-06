package antiSpamFilter;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 * @author Guilherme Pereira
 */
public class AntiSpamFilterConfiguration {

	private JFrame frame;
	private JPanel globalPanel;
	private JPanel topPanel;
	private JPanel centralPanel;
	private JTextField fieldRules;
	private JTextField fieldSpam ;
	private JTextField fieldHam;


	/**
	 * This constructor creates a frame and calls a method that operates on it
	 */
	public AntiSpamFilterConfiguration() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setTitle("Filtro Anti-Spam");
		
		addFrameContent();
	}


	/**
	 * This operation constructs the global panel and has two methods 
	 * to construct and operate on the top and central panels
	 */
	private void addFrameContent() {
		globalPanel = new JPanel();
		globalPanel.setLayout(new BorderLayout());
		frame.add(globalPanel);
		
		constructTopPanel();
		constructAndOperateOnCentralPanel();
	}
	
	
	/**
	 * This operation constructs the top panel with its labels and fields
	 */
	private void constructTopPanel() {
		topPanel = new JPanel();
		
		globalPanel.add(topPanel,BorderLayout.NORTH);		
		topPanel.setLayout(new GridLayout(5,2));

		JLabel label1 = new JLabel(" Caminho para os ficheiros de configuração:");
		topPanel.add(label1);
		
		JLabel labelSpace1 = new JLabel("");
		topPanel.add(labelSpace1);
		
		fieldRules = new JTextField();
		topPanel.add(fieldRules);
		
		JLabel labelRules = new JLabel(" rules.cf");
		topPanel.add(labelRules);
		
		fieldSpam = new JTextField();
		topPanel.add(fieldSpam);
		
		JLabel labelSpam = new JLabel(" spam.log");
		topPanel.add(labelSpam);
		
		fieldHam = new JTextField();
		topPanel.add(fieldHam);
		
		JLabel labelHam = new JLabel(" ham.log");
		topPanel.add(labelHam);
	}
	
	
	/**
	 * This operation initializes the central panel
	 * and has two methods to construct and operate on that central panel
	 */
	private void constructAndOperateOnCentralPanel() {
		centralPanel = new JPanel();
		
		globalPanel.add(centralPanel,BorderLayout.CENTER);		
		centralPanel.setLayout(new GridLayout(16,2));
		
		ManualConfiguration manualConfiguration = new ManualConfiguration(centralPanel, fieldRules, fieldSpam, fieldHam);
		manualConfiguration.operationsOfManualConfiguration();
		
		AutomaticConfiguration automaticConfiguration = new AutomaticConfiguration(centralPanel, manualConfiguration);
		automaticConfiguration.operationsOfAutomaticConfiguration();
	}

	
	/**
	 * This operation makes the frame visible and with a specific size
	 */
	private void open() {
		frame.setVisible(true);
		frame.setSize(700,980);
	}
	
	
	/**
	 * Main method of the application responsible for executing it
	 * @param args
	 */
	public static void main(String[] args) {
		AntiSpamFilterConfiguration a = new AntiSpamFilterConfiguration();
		a.open();
	}
	
	
	/**
	 * Method to return the frame
	 * @return JFrame - The frame
	 */
	public JFrame getFrame() {
		return frame;
	}

	/**
	 * Method to return the global panel
	 * @return JPanel - The global panel
	 */
	public JPanel getGlobalPanel() {
		return globalPanel;
	}

	/**
	 * Method to return the top panel
	 * @return JPanel - The top panel
	 */
	public JPanel getTopPanel() {
		return topPanel;
	}

	/**
	 * Method to return the field with the path to the file 'rules.cf'
	 * @return JTextField - The field with the path to the file 'rules.cf'
	 */
	public JTextField getFieldRules() {
		return fieldRules;
	}

	/**
	 * Method to return the field with the path to the file 'spam.log'
	 * @return JTextField - The field with the path to the file 'spam.log'
	 */
	public JTextField getFieldSpam() {
		return fieldSpam;
	}

	/**
	 * Method to return the field with the path to the file 'ham.log'
	 * @return JTextField - The field with the path to the file 'ham.log'
	 */
	public JTextField getFieldHam() {
		return fieldHam;
	}
}