package RabiTracker.data;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.lang.reflect.Field;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import RabiTracker.MemoryData;
import RabiTracker.Window;
import RabiTracker.data.structures.DifficultyStruct;
import sig.utils.DrawUtils;
import sig.utils.JavaUtils;
import sig.utils.TextUtils;

public class Profile {
	public String username = Window.USERNAME.toLowerCase();
	public String displayName = Window.USERNAME;
	public Avatar avatar;
	public int playtime = 0;
	public int healthUps = 0;
	public int attackUps = 0;
	public int manaUps = 0;
	public int regenUps = 0;
	public int packUps = 0;
	public int rainbowEggCount = 0;
	public boolean isPaused = false;
	public int difficulty = 0;
	public int loop = 0;
	public float itempct = 0;
	public float mappct = 0;
	public LinkedHashMap<MemoryData,Integer> key_items = new LinkedHashMap<MemoryData,Integer>();
	public LinkedHashMap<MemoryData,Integer> badges = new LinkedHashMap<MemoryData,Integer>();
	public List<String> updates = new ArrayList<String>();
	public long lastWebUpdate = System.currentTimeMillis(); 
	DecimalFormat df = new DecimalFormat("0.0");
	Profile oldProfile;
	public boolean isArchive = false;
	final static Color TEAL = new Color(0,128,128);
	final static Color TEAL_TRANSPARENT = new Color(255,255,0,210);
	final static Color TRANSPARENT = new Color(0,0,0,0);
	final static Color DEACTIVATED_ITEM = new Color(0,0,0,128);
	public Image statUpdateCacheImage;
	public Image imageDisplayUpdateImage;
	public boolean stat_update_required = true;
	public boolean image_display_update_required = true;
	
	public void update() {
		
	}
	
	public void slowTick() {
		for (MemoryData md : MemoryData.values()) {
			if (md.isItem()) {
				Integer val = Window.MAIN_WINDOW.mem.readIntFromMemory(md);
				if (md.isKeyItem()) {
					if (key_items.containsKey(md)) { 
						if (key_items.get(md)!=val) {
							if (val==0) {
								key_items.remove(md);
							} else {
								key_items.put(md, val);
								image_display_update_required=true;
							}
						}
					}
					else {
						if (val!=0) {
							key_items.put(md, val);
							image_display_update_required=true;
						}
					}
				} else {
					if (badges.containsKey(md)) {
						if (badges.get(md)!=val) {
							if (val==0) {
								badges.remove(md);
							} else {
								badges.put(md, val);
								image_display_update_required=true;
							}
						}
					} else {
						if (val!=0) {
							badges.put(md, val);
							image_display_update_required=true;
						}
					}
				}
			} else {
				int val = Window.MAIN_WINDOW.mem.readIntFromMemory(md);
				float floatval = Window.MAIN_WINDOW.mem.readFloatFromMemory(md);
				switch (md) {
				case GAME_DIFFICULTY:
						if (difficulty!=val) {
							difficulty = val;
							image_display_update_required=true;
						}
					break;
				case GAME_LOOP:
						if (loop!=val) {
							loop = val;
							image_display_update_required=true;
						}
					break;
				case ITEM_PERCENT:
					if (itempct!=floatval) {
						itempct = floatval;
						image_display_update_required=true;
					}
				break;
				case MAP_PERCENT:
					if (mappct!=floatval) {
						mappct = floatval;
						image_display_update_required=true;
					}
					break;
				case MONEY:
						//TODO Not implemented.
					break;
				case PAUSED:
						if (((isPaused)?1:0)!=val) {
							isPaused = (val==1)?true:false;
							image_display_update_required=true;
						}
					break;
				case PLAYTIME:
						if (playtime!=val) {
							playtime = val;
							image_display_update_required=true;
						}
					break;
				}
			}
		}
		
		int healthUpCount = Window.MAIN_WINDOW.mem.readItemCountFromMemory(MemoryData.HEALTHUP_START,MemoryData.HEALTHUP_END);
		int manaUpCount = Window.MAIN_WINDOW.mem.readItemCountFromMemory(MemoryData.MANAUP_START,MemoryData.MANAUP_END);
		int attackUpCount = Window.MAIN_WINDOW.mem.readItemCountFromMemory(MemoryData.ATTACKUP_START,MemoryData.ATTACKUP_END);
		int regenUpCount = Window.MAIN_WINDOW.mem.readItemCountFromMemory(MemoryData.REGENUP_START,MemoryData.REGENUP_END);
		int packUpCount = Window.MAIN_WINDOW.mem.readItemCountFromMemory(MemoryData.PACKUP_START,MemoryData.PACKUP_END);
		int rainbowEggs = Window.MAIN_WINDOW.mem.readIntFromMemory(MemoryData.RAINBOW_EGG_COUNT);
		if (healthUpCount!=healthUps) {
			healthUps = healthUpCount;
			image_display_update_required=true;
		}
		if (manaUpCount!=manaUps) {
			manaUps = manaUpCount;
			image_display_update_required=true;
		}
		if (attackUpCount!=attackUps) {
			attackUps = attackUpCount;
			image_display_update_required=true;
		}
		if (regenUpCount!=regenUps) {
			regenUps = regenUpCount;
			image_display_update_required=true;
		}
		if (packUpCount!=packUps) {
			packUps = packUpCount;
			image_display_update_required=true;
		}
		if (rainbowEggs!=rainbowEggCount) {
			rainbowEggCount=rainbowEggs;
			image_display_update_required=true;
		}
		
		System.out.println(this);
	}
	
	public void draw(Graphics g,Session s) {
		if (image_display_update_required) {
			imageDisplayUpdateImage = getStatPanel(Window.MAIN_WINDOW.panel.getWidth(),s);
			image_display_update_required=false;
		}
		g.drawImage(imageDisplayUpdateImage, 0, 0, Window.MAIN_WINDOW);
	}
	
	private Image getStatPanel(int w, Session session) {
		BufferedImage tmp = new BufferedImage(w,175,BufferedImage.TYPE_INT_ARGB);
		Graphics g = tmp.createGraphics();
		switch (session.gamemode) {
			case EGGMODE:{
				
			}break;
			case ITEMMODE:{
				
			}break;
			case BINGO:{
				
			}break;
			case TENTM:{
				
			}break;
			case MARATHON:{
				
			}break;
			case POSTGAME:{
				
			}break;
		}
		
		final int font_height = (int)TextUtils.calculateStringBoundsFont(Window.USERNAME, Window.MAIN_WINDOW.SYSTEM_FONT).getHeight();
		DifficultyStruct diff = DifficultyStruct.GetDifficulty(difficulty);
		final int difficulty_width = (int)TextUtils.calculateStringBoundsFont(diff.getDifficultyName(), Window.MAIN_WINDOW.SYSTEM_FONT).getWidth();
		
		
		DrawUtils.drawOutlineText(g, Window.MAIN_WINDOW.SYSTEM_FONT, 0, (font_height+4)*1, 2, Color.WHITE, Color.BLACK, Window.USERNAME);
		DrawUtils.drawOutlineText(g, Window.MAIN_WINDOW.SYSTEM_FONT, 0, (font_height+4)*2, 2, diff.getDifficultyColor(), Color.WHITE, diff.getDifficultyName());
		if (loop>1) {
			DrawUtils.drawOutlineText(g, Window.MAIN_WINDOW.SYSTEM_FONT, difficulty_width+8, (font_height+4)*2, 2, diff.getDifficultyColor(), Color.WHITE, "Loop "+loop);
		}
		//DrawUtils.drawTextFont(g, Window.MAIN_WINDOW.SYSTEM_FONT, 0, font_height+(1*2), diff.getDifficultyColor(), diff.getDifficultyName());
		
		int yoffset = (font_height+4)*2;
		int keyItemCount = key_items.size();
		int badgeItemCount = badges.size();
		int keyItemsPlaced = 0;
		int badgesPlaced = 0;
		final int icon_size = 24;
		int icon_spacing = Math.min((int)(w/(double)keyItemCount),icon_size+2);
		int badge_icon_spacing = Math.min((int)(w/(double)badgeItemCount),icon_size+2);
		
		for (MemoryData md : key_items.keySet()) {
			//g.drawImage(img, x, y, observer)
			DrawUtils.drawImageScaled(g, md.getImage(), (icon_spacing*keyItemsPlaced), yoffset+icon_size*1.5, icon_size, icon_size, (key_items.get(md)<0)?DEACTIVATED_ITEM:TRANSPARENT, Window.MAIN_WINDOW);
			keyItemsPlaced++;
		}
		yoffset+=32;
		for (MemoryData md : badges.keySet()) {
			//g.drawImage(img, x, y, observer)
			if (badges.get(md)==2) {
				g.setColor(TEAL_TRANSPARENT);
				g.drawOval((int)((badge_icon_spacing*badgesPlaced)), (int)(yoffset+icon_size*1.5), 23, 23);
				g.setColor(Color.BLACK);
			}
			DrawUtils.drawImageScaled(g, md.getImage(), (badge_icon_spacing*badgesPlaced), yoffset+icon_size*1.5, icon_size, icon_size, TRANSPARENT, Window.MAIN_WINDOW);
			badgesPlaced++;
		}
		
		return tmp.getScaledInstance(w, -1, Image.SCALE_AREA_AVERAGING);
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.getClass().getName()+"(");
		boolean first=false;
		for (Field f : this.getClass().getDeclaredFields()) {
			if (!first) {
				try {
					sb.append(f.getName()+"="+f.get(this));
					first=true;
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			} else {
				try {
					sb.append(","+f.getName()+"="+f.get(this));
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
		sb.append(")");
		return sb.toString();
	}
}
