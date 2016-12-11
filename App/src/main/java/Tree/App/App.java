package Tree.App;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.geom.Line2D;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JTextField;


/* Basic application employing swing library to generate a basic tree shape, */
public class App extends JFrame {
	
	//Panels
	JPanel mainPanel = new JPanel();
	JPanel controlPanel = new JPanel();
	JPanel drawPanel = new JPanel();
	
	//Buttons
	JButton btnDrawTree = new JButton("Draw Tree");
	
	//Fields
	JTextField txtFieldLineHeight = new JTextField(5);
	
	
	
	public static void main (String[] args){
		EventQueue.invokeLater(() -> {
			try {
				App gameInstance = new App();
				gameInstance.setVisible(true);
			} catch(Exception e) {
				e.printStackTrace();
			}
		});
	}
	
	public App(){
		initUI();
	}
	
	private void initUI(){
		setTitle("Basic Tree Game App - Prototype");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(true);
		setSize(600,600);
		
		initBtnActions();
		populateElements();		
	}
	
	private void initBtnActions(){
		btnDrawTree.setMnemonic(KeyEvent.VK_D);
		btnDrawTree.addActionListener(null);
		
		
		//
	}
	
	private void populateElements(){
		//Colour panels
		//mainPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		drawPanel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		drawPanel.setBackground(Color.GREEN);
		controlPanel.setBackground(Color.YELLOW);
		
		//Add Button and text box to controlPanel
		controlPanel.setMaximumSize(new Dimension(1000000, 100));
		controlPanel.add(txtFieldLineHeight);
		controlPanel.add(btnDrawTree);
		
		
		//Set layout type of container panel and added sub panels
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		mainPanel.add(drawPanel);
		mainPanel.add(controlPanel);
		
		
		//Add main panel to JFrame
		this.add(mainPanel);		
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		Line2D treeTrunk = new Line2D.Float(100, 100, 100, 200);
		g2d.draw(treeTrunk);
	}
		
}