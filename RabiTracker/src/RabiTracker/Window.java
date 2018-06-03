package RabiTracker;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import RabiTracker.data.RabiTracker;

public class Window extends JFrame{
	final static String WINDOW_TITLE = "Rabi Tracker v1.0";
	public static int MAX_FPS = 60;
	
	public static int TICK = 0;
	public static Font SYSTEM_FONT;
	
	public static String USERNAME = "Sig"; //TODO Make a way for users to input their username.
	public static String RABI_RIBI_VERSION = "1.90"; //TODO Make a way to detect the version of the game.
	
	public static Window MAIN_WINDOW;
	
	JFrame window = new JFrame("Rabi Tracker v1.0");
	public DrawingPanel panel = new DrawingPanel(this); 
	
	public MemoryManager mem = new MemoryManager();
	RabiTracker tracker = new RabiTracker();
	
	int timer = Calendar.getInstance().get(Calendar.SECOND);
	public int frames = 0;
	
	public static HashMap<String,Image> image_map = new HashMap<String,Image>();
	
	public void setTitle(String str) {
		window.setTitle(WINDOW_TITLE+" "+str);
	}
	
	public void drawGUI(Graphics g) {
		//g.drawImage(image_map.get("ribbon.png"), 32,32, window);
		tracker.draw(g);
	}
	
	
	public void display() {
		InputStream stream = Window.class.getResourceAsStream("/CP_Font.ttf");
		//File font = new File(sigIRC.BASEDIR+"sigIRC/CP_Font.ttf");
		
		try {
			SYSTEM_FONT = Font.createFont(Font.TRUETYPE_FONT,stream);
			GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(SYSTEM_FONT);
			SYSTEM_FONT = new Font("CP Font",0,16);
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
		}
		
		window.setSize(640, 480);
		window.setResizable(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel.setSize(640, 480);
		panel.setBackground(Color.MAGENTA);
		
		window.getContentPane().add(panel);
		window.setVisible(true);
		
		MemoryData.loadMemoryData();
		
		AddImagesToImageMap(new File("./rabi-ribi/items"),"./rabi-ribi/items/");
		AddImagesToImageMap(new File("./rabi-ribi/characters"),"./rabi-ribi/characters/");
		System.out.println("Loaded unknown.png");
		try {
			image_map.put("unknown.png", ImageIO.read(new File("./rabi-ribi/unknown.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void runTick() {
		Window.TICK++;
		panel.repaint();
		
		mem.update();
		tracker.update();
	}
	
	public void slowTick() {
		tracker.slowTick();
	}
	
	public void update() {
		int new_val = Calendar.getInstance().get(Calendar.SECOND);
		if (new_val!=timer) {
			setTitle("- "+frames+" FPS");
			frames=0;
			timer = new_val;
			slowTick();
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
		MAIN_WINDOW = program;
		program.display();
		while (true) {
			program.update();
		}
	}
	
	private void AddImagesToImageMap(File dir, String DIRECTORY) {
		String[] images = dir.list();
		List<String> filtered_images = new ArrayList<String>();
		for (String file : images) {
			File f = new File(DIRECTORY+file);
			if (!f.isDirectory()) {
				filtered_images.add(file);
			}
		}
		images = filtered_images.toArray(new String[filtered_images.size()]);
		for (String image : images) {
			try {
				System.out.println("Loaded "+image);
				image_map.put(image, ImageIO.read(new File(DIRECTORY+image)));
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
	}
}
