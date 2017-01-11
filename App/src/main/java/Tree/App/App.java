package Tree.App;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.geom.Line2D;
import java.util.List;
import java.util.Queue;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/* Basic application employing swing library to generate a basic tree shape, */
public class App extends JFrame implements ActionListener {

	// Panels
	JPanel mainPanel = new JPanel();
	JPanel controlPanel = new JPanel();
	JPanel drawPanel = new JPanel();

	// Buttons
	JButton btnDrawTree = new JButton("Draw Tree");

	// Fields
	JTextField txtFieldLineHeight = new JTextField(5);

	BasicTreeImpl tree, tree2;

	public static void main(String[] args) {

		EventQueue.invokeLater(() -> {
			try {
				App gameInstance = new App();
				gameInstance.initTree();
				gameInstance.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public App() {
		initUI();
	}

	private void initUI() {
		setTitle("Basic Tree Game App - Prototype");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(true);
		setSize(600, 600);

		initBtnActions();
		populateElements();
	}

	private void initBtnActions() {
		btnDrawTree.setMnemonic(KeyEvent.VK_D);
		btnDrawTree.addActionListener(this);
	}

	private void populateElements() {
		// Colour panels
		// mainPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		drawPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		drawPanel.setBackground(Color.GREEN);
		controlPanel.setBackground(Color.YELLOW);

		// Add Button and text box to controlPanel
		controlPanel.setMaximumSize(new Dimension(1000000, 100));
		controlPanel.add(txtFieldLineHeight);
		controlPanel.add(btnDrawTree);

		// Set layout type of container panel and added sub panels
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		mainPanel.add(drawPanel);
		mainPanel.add(controlPanel);

		// Add main panel to JFrame
		this.add(mainPanel);
	}

	public void paint(Graphics g) {
		super.paint(g);
		paintTree(g);
		paintTree2(g);	

	}
	
	public void paintTree(Graphics g){
		List<Node> depthFirstTree = tree.getTreeAsArray();
		for(Node n : depthFirstTree){
			drawCircle(g, n.getX(), n.getY(), 2);
			for(Node c : n.getChildren()){
				if (c != null)
					drawLine(g, n.getX(), n.getY(), c.getX(), c.getY());
					try {
						Thread.sleep(10);
					} catch(InterruptedException ie){
						System.err.println("GAYYYY");
						System.exit(1);
					}
			}
		}
		
	}
	
	public void paintTree2(Graphics g){
		List<Node> depthFirstTree = tree2.getTreeAsArray();
		for(Node n : depthFirstTree){
			drawCircle(g, n.getX(), n.getY(), 2);
			for(Node c : n.getChildren()){
				if (c != null)
					drawLine(g, n.getX(), n.getY(), c.getX(), c.getY());
					try {
						Thread.sleep(10);
					} catch(InterruptedException ie){
						System.err.println("GAYYYY");
						System.exit(1);
					}
			}
		}
		
	}


	public void initTree(){
		tree = new BasicTreeImpl();
		int treeSize = (int)(Math.random() * 100);
		System.out.println("Tree size: " + treeSize);
		for(int i=0; i<treeSize; i++){
			tree.addNode((int)(Math.random()*1000));
		}		
	}
	
	public void initTree2(){
		tree2 = new BasicTreeImpl();
		int treeSize = (int)(Math.random() * 100);
		System.out.println("Tree2 size: " + treeSize);
		for(int i=0; i<treeSize; i++){
			tree.addNode((int)(Math.random()*1000));
		}		
	}
	
	public void drawCircle(Graphics g, int x, int y, int radius) {
		  int diameter = radius * 2;
		  //shift x and y by the radius of the circle in order to correctly center it
		  g.fillOval(x - radius, y - radius, diameter, diameter); 

		}
	
	/* Method currently pointless. Added for later functionality i.e. drawing lines will be more complex */
	public void drawLine(Graphics g, int x, int y, int childX, int childY) {
		  g.drawLine(x, y, childX, childY);

		}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		initTree();
		initTree2();
		repaint();
		
	}
	
	
	
}