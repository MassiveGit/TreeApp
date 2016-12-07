package Tree.App;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;


/* Basic application employing swing library to generate a basic tree shape, */
public class App extends JFrame {
	
	//Panels
	JPanel mainPanel = new JPanel();
	
	//Buttons
	JButton btnDrawTree = new JButton("Draw Tree");
	
	//Fields
	JTextField txtFieldLineHeight = new JTextField(5);
	
	
	
	public static void main (String[] args){
		EventQueue.invokeLater(() -> {
			App gameInstance = new App();
			gameInstance.setVisible(true);
		});
		
	}
	
	public App(){
		initUI();
	}
	
	private void initUI(){
		setTitle("Basic Tree Game App - Prototype");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(600,600);
		setResizable(true);
		
		//Populate elements:
		
		
	}
		
}