package RabiTracker.data;

public enum SessionType {
	EGGMODE(0),
	ITEMMODE(1),
	BINGO(2),
	TENTM(3),
	MARATHON(4),
	POSTGAME(5);
	
	int id;
	
	SessionType(int id) {
		this.id=id;
	}
	
	public int getID() {
		return id;
	}
}
