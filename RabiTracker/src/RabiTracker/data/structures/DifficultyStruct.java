package RabiTracker.data.structures;

import java.awt.Color;

public enum DifficultyStruct {
	CASUAL(new Color(99, 159, 255),"Casual"),
	NOVICE(new Color(119, 98, 255),"Novice"),
	NORMAL(new Color(60, 201, 112),"Normal"),
	HARD(new Color(200, 209, 100),"Hard"),
	HELL(new Color(209, 159, 12),"Hell"),
	BEX(new Color(209, 54, 11),"BEX"),
	UNKNOWN(new Color(68, 24, 12),"Unknown"),
	IMPOSSIBLE(new Color(12, 24, 68),"Impossible"),
	EXTRA(new Color(64, 64, 64),"Extra"),
	;
	
	DifficultyStruct(Color col, String name) {
		this.color = col;
		this.name = name;
	}
	
	public String getDifficultyName() {
		return name;
	}
	
	public Color getDifficultyColor() {
		return color;
	}
	
	Color color;
	String name;
	
	public static DifficultyStruct GetDifficulty(int difficulty) {
		switch (difficulty) {
			case 0:{
				return CASUAL;
			}
			case 1:{
				return NOVICE;
			}
			case 2:{
				return NORMAL;
			}
			case 3:{
				return HARD;
			}
			case 4:{
				return HELL;
			}
			case 5:{
				return BEX;
			}
			case 6:{
				return UNKNOWN;
			}
			case 7:{
				return IMPOSSIBLE;
			}
			default:{
				return EXTRA;
			}
		}
	}
	
	/*
	 * Color[] color_list = new Color[]{
				new Color(99, 159, 255),
				new Color(119, 98, 255),
				new Color(60, 201, 112),
				new Color(200, 209, 100),
				new Color(209, 159, 12),
				new Color(209, 54, 11),
				new Color(68, 24, 12),
		};
	 */
}
