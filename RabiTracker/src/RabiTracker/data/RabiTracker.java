package RabiTracker.data;

import java.awt.Graphics;
import java.util.HashMap;
import RabiTracker.Window;

public class RabiTracker {
	Profile myProfile;
	HashMap<String,Profile> profile_list = new HashMap<String,Profile>();
	/*LinkedHashMap<MemoryData,Integer> key_items = new LinkedHashMap<MemoryData,Integer>();
	LinkedHashMap<MemoryData,Integer> badges = new LinkedHashMap<MemoryData,Integer>();*/
	Session mySession;
	
	public RabiTracker() {
		myProfile = new Profile();
		mySession = new Session();
	}
	
	public void update() {
		if (Window.MAIN_WINDOW.mem.foundRabiRibi()) {
			myProfile.update();
		}
	}
	
	public void slowTick() {
		if (Window.MAIN_WINDOW.mem.foundRabiRibi()) {
			myProfile.slowTick();
		}
	}
	
	public void draw(Graphics g) {
		if (Window.MAIN_WINDOW.mem.foundRabiRibi()) {
			myProfile.draw(g,mySession);
		}
	}
}
