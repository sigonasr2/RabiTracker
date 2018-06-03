package RabiTracker.data;

import java.util.ArrayList;
import java.util.List;


public class Session {
	long creationTime = 0;
	long updateTime = 0;
	String name = "";
	int maxPlayers = 0;
	String password = "";
	float difficulty = -1;
	SessionType gamemode = SessionType.EGGMODE; //0 = Egg Mode, 1 = Item Hunt Mode
	String[] itemHuntData;
	int eggCount = 0;
	int id = 0;
	List<Profile> players = new ArrayList<Profile>();
}
