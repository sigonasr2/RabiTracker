package RabiTracker;

import java.awt.Graphics;

import javax.swing.JPanel;

public class DrawingPanel extends JPanel {
	Window parent;
	
	public DrawingPanel(Window parent) {
		this.parent = parent;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		parent.drawGUI(g);
		
		parent.frames++;
	}
}