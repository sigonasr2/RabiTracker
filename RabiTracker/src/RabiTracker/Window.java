package RabiTracker;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Calendar;
import java.util.Timer;

import javax.swing.JFrame;
import javax.swing.JPanel;

class DrawingPanel extends JPanel {
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

public class Window extends JFrame{
	final static String WINDOW_TITLE = "Rabi Tracker v1.0";
	public static int MAX_FPS = 60;
	
	public static int TICK = 0;
	
	JFrame window = new JFrame("Rabi Tracker v1.0");
	DrawingPanel panel = new DrawingPanel(this); 
	
	MemoryManager mem = new MemoryManager();
	
	int timer = Calendar.getInstance().get(Calendar.SECOND);
	public int frames = 0;
	
	public void setTitle(String str) {
		window.setTitle(WINDOW_TITLE+" "+str);
	}
	
	public void drawGUI(Graphics g) {
		
	}
	
	
	public void display() {
		window.setSize(640, 480);
		window.setResizable(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel.setSize(640, 480);
		panel.setBackground(Color.MAGENTA);
		
		window.getContentPane().add(panel);
		window.setVisible(true);
	}
	
	private void runTick() {
		Window.TICK++;
		panel.repaint();
	}
	
	public void update() {
		int new_val = Calendar.getInstance().get(Calendar.SECOND);
		int current_tick = Calendar.getInstance().get(Calendar.MILLISECOND);
		if (new_val!=timer) {
			setTitle("- "+frames+" FPS");
			frames=0;
			timer = new_val;
		}
		try {
			runTick();
			Thread.sleep((long)(1000d/MAX_FPS));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		System.setProperty("sun.java2d.opengl", "True");
		
		Window program = new Window();
		program.display();
		while (true) {
			program.update();
		}
	}
}
