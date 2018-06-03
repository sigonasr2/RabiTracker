package RabiTracker;

import java.awt.Image;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;

import sig.utils.DebugUtils;
import sig.utils.FileUtils;

public enum MemoryData {
	MONEY(0xD654CC),
	PLAYTIME(0xD642D8),
	HEALTHUP_START(0xD6342C),
	HEALTHUP_END(0xD63528),
	ATTACKUP_START(0xD6352C),
	ATTACKUP_END(0xD63628),
	MANAUP_START(0xD6362C),
	MANAUP_END(0xD63728),
	REGENUP_START(0xD6372C),
	REGENUP_END(0xD63828),
	PACKUP_START(0xD6382C),
	PACKUP_END(0xD63928),
	/*ENTITY_ARRAY(0x0096DA3C), //Erina Data Pointer.
	ERINA_HP(0x4D8),
	ERINA_MAXHP(0x4E8),
	ERINA_XPOS(0xC),
	ERINA_YPOS(0x10),
	ERINA_XSPEED(0x470), //Relative to Entity Array.
	ERINA_YSPEED(0x474), //Relative to Entity Array.
	MAPID(0xA600AC),
	CAMERA_XPOS(0x991AF4),
	CAMERA_YPOS(0xABD0A4),
	//ENTITY_SIZE(0x704),
	ENTITY_ID(0x4F4),
	ENTITY_HP(0x4D8),
	ENTITY_MAXHP(0x4E8),
	ENTITY_ISACTIVE(0x674),
	ENTITY_ANIMATION(0x678),
	ENTITY_XPOS(0xC),
	ENTITY_YPOS(0x10),
	ENTITY_COLOR(0x1C),
	TRANSITION_COUNTER(0xA7661C),*/
	//WARP_TRANSITION_COUNTER(0,0x582CE0+OffsetHelper.KEY_ITEM_OFFSET_V185_TO_V1851), //Detects pausing
	
	
	
	GAME_DIFFICULTY(0xD64338),
	GAME_LOOP(0xD6D05C),
	
	HAMMER(0xD632B0,"Hammer","piko_hammer.png",true),
	AIR_JUMP(0xD632B4,"Air Jump","air_jump.png",true),
	SLIDING_POWDER(0xD632B8,"Sliding Powder","sliding_powder.png",true),
	CARROT_BOMB(0xD632BC,"Carrot Bomb","carrot_bomb.png",true),
	HOURGLASS(0xD632C0,"Hourglass","hourglass.png",true),
	SPEED_BOOST(0xD632C4,"Speed Boost","speed_boost.png",true),
	AUTO_EARRINGS(0xD632C8,"Auto Earrings","auto_earrings.png",true),
	RIBBON(0xD632CC,"Ribbon","ribbon.png",true),
	SOUL_HEART(0xD632D0,"Soul Heart","soul_heart.png",true),
	RABI_SLIPPERS(0xD632D4,"Rabi Slippers","rabi_slippers.png",true),
	BUNNY_WHIRL(0xD632D8,"Bunny Whirl","bunny_whirl.png",true),
	QUICK_BARETTE(0xD632DC,"Quick Barrette","quick_barrette.png",true),
	BOOK_OF_CARROT(0xD632E0,"Book of Carrot","book_of_carrot.png",true),
	CHAOS_ROD(0xD632E4,"Chaos Rod","chaos_rod.png",true),
	HAMMER_WAVE(0xD632E8,"Hammer Wave","hammer_wave.png",true),
	HAMMER_ROLL(0xD632EC,"Hammer Roll","hammer_roll.png",true),
	LIGHT_ORB(0xD632F0,"Light Orb","light_orb.png",true),
	WATER_ORB(0xD632F4,"Water Orb","water_orb.png",true),
	FIRE_ORB(0xD632F8,"Fire Orb","fire_orb.png",true),
	NATURE_ORB(0xD632FC,"Nature Orb","nature_orb.png",true),
	P_HAIRPIN(0xD63300,"P. Hairpin","p_hairpin.png",true),
	SUNNY_BEAM(0xD63304,"Sunny Beam","sunny_beam.png",true),
	PLUS_NECKLACE(0xD63308,"Plus Necklace","plus_necklace.png",true),
	CYBER_FLOWER(0xD6330C,"Cyber Flower","cyber_flower.png",true),
	HEALING_STAFF(0xD63310,"Healing Staff","healing_staff.png",true),
	MAX_BRACELET(0xD63314,"Max Bracelet","max_bracelet.png",true),
	EXPLODE_SHOT(0xD63318,"Explode Shot","explode_shot.png",true),
	AIR_DASH(0xD6331C,"Air Dash","air_dash.png",true),
	BUNNY_STRIKE(0xD63320,"Bunny Strike","bunny_strike.png",true),
	STRANGE_BOX(0xD63324,"Strange Box","strange_box.png",true),
	WALL_JUMP(0xD63328,"Wall Jump","wall_jump.png",true),
	SPIKE_BARRIER(0xD6332C,"Spike Barrier","spike_barrier.png",true),
	BUNNY_AMULET(0xD63330,"Bunny Amulet","bunny_amulet.png",true),
	CHARGE_RING(0xD63334,"Charge Ring","charge_ring.png",true),
	CARROT_SHOOTER(0xD63338,"Carrot Shooter","carrot_shooter.png",true),
	SUPER_CARROT(0xD6333C,"Super Carrot","super_carrot.png",true),
	RUMI_DONUT(0xD63340),
	RUMI_CAKE(0xD63344),
	GOLD_CARROT(0xD63348,"Gold Carrot","gold_carrot.png",true),
	COCOA_BOMB(0xD6334C),
	UNKNOWN_ITEM1(0xD63350),
	TROPHY(0xD63354),
	EXCLAMATION_POINT(0xD63358),
	UNKNOWN_ITEM2(0xD6335C),
	UNKNOWN_ITEM3(0xD63360),
	UNKNOWN_ITEM4(0xD63364),
	RAINBOW_MAGIC(0xD63368),
	UNKNOWN_ITEM5(0xD6336C),
	UNKNOWN_ITEM6(0xD63370),
	UNKNOWN_ITEM7(0xD63374),
	UNKNOWN_ITEM8(0xD63378),
	UNKNOWN_ITEM9(0xD6337C),
	UNKNOWN_ITEM10(0xD63380),
	UNKNOWN_ITEM11(0xD63384),
	UNKNOWN_ITEM12(0xD63388),
	UNKNOWN_ITEM13(0xD6338C),
	UNKNOWN_ITEM14(0xD63390),
	/*DLC_ITEM1(0xD63394,0xD63394+OffsetHelper.KEY_ITEM_OFFSET_V175_TO_V1851),
	DLC_ITEM2(0xD63398,0xD63398+OffsetHelper.KEY_ITEM_OFFSET_V175_TO_V1851),*/
	BUNNY_CLOVER(0xD6339C,"Bunny Clover","bunny_clover.png",true),
	FAIRYS_FLUTE(0xD643A4,"Fairy's Flute","fairy_s_flute.png",true),
	BUNNY_MEMORIES(0xD623A8,"Bunny Memories","bunny_memories.png",true),
	WIND_BLESSING(0xD623A0,"Wind Blessing","wind_blessing.png",true),
	DLC_ITEM4(0xD633A0),
	BADGE_HEALTH_PLUS(0xD633AC,"Health Plus","health_plus.png",false),
	BADGE_HEALTH_SURGE(0xD633B0,"Health Surge","health_surge.png",false),
	BADGE_MANA_PLUS(0xD633B4,"Mana Plus","mana_plus.png",false),
	BADGE_MANA_SURGE(0xD633B8,"Mana Surge","mana_surge.png",false),
	BADGE_CRISIS_BOOST(0xD633BC,"Crisis Boost","crisis_boost.png",false),
	BADGE_ATK_GROW(0xD633C0,"ATK Grow","atk_grow.png",false),
	BADGE_DEF_GROW(0xD633C4,"DEF Grow","def_grow.png",false),
	BADGE_ATK_TRADE(0xD633C8,"ATK Trade","atk_trade.png",false),
	BADGE_DEF_TRADE(0xD633CC,"DEF Trade","def_trade.png",false),
	BADGE_ARM_STRENGTH(0xD633D0,"Arm Strength","arm_strength.png",false),
	BADGE_CARROT_BOOST(0xD633D4,"Carrot Boost","carrot_boost.png",false),
	BADGE_WEAKEN(0xD633D8,"Weaken","weaken.png",false),
	BADGE_SELF_DEFENSE(0xD633DC,"Self Defense","self_defense.png",false),
	BADGE_ARMORED(0xD633E0,"Armored","armored.png",false),
	BADGE_LUCKY_SEVEN(0xD633E4,"Lucky Seven","lucky_seven.png",false),
	BADGE_HEX_CANCEL(0xD633E8,"Hex Cancel","hex_cancel.png",false),
	BADGE_PURE_LOVE(0xD633EC,"Pure Love","pure_love.png",false),
	BADGE_TOXIC_STRIKE(0xD633F0,"Toxic Strike","toxic_strike.png",false),
	BADGE_FRAME_CANCEL(0xD633F4,"Frame Cancel","frame_cancel.png",false),
	BADGE_HEALTH_WAGER(0xD633F8,"Health Wager","health_wager.png",false),
	BADGE_MANA_WAGER(0xD633FC,"Mana Wager","mana_wager.png",false),
	BADGE_STAMINA_PLUS(0xD63400,"Stamina Plus","stamina_plus.png",false),
	BADGE_BLESSED(0xD63404,"Blessed","blessed.png",false),
	BADGE_HITBOX_DOWN(0xD63408,"Hitbox Down","hitbox_down.png",false),
	BADGE_CASHBACK(0xD6340C,"Cashback","cashback.png",false),
	BADGE_SURVIVAL(0xD63410,"Survival","survival.png",false),
	BADGE_TOP_FORM(0xD63414,"Top Form","top_form.png",false),
	BADGE_TOUGH_SKIN(0xD63418,"Tough Skin","tough_skin.png",false),
	BADGE_ERINA_BADGE(0xD6341C,"Erina","erina_badge.png",false),
	BADGE_RIBBON_BADGE(0xD63420,"Ribbon","ribbon_badge.png",false),
	BADGE_AUTO_TRIGGER(0xD63424,"Auto Trigger","auto_trigger.png",false),
	BADGE_LILITHS_GIFT(0xD63428,"Lilith's Gift","lilith_s_gift.png",false),
	//13413E8
	ITEM_PERCENT(0),
	MAP_PERCENT(0),
	RAINBOW_EGG_COUNT(0xD65FD4),
	PAUSED(0),
	;
	
	HashMap<String,Long> memoryMap = new HashMap<String,Long>();
	String itemName = "[UNKNOWN]";
	String imgName = "unknown.png";
	boolean keyItem = false; //Whether or not item is a key item.
	boolean isItem = false; //Whether or not this is an item.
	
	MemoryData(long baseAddress) {
		memoryMap.put("1.75", baseAddress);
	}
	
	MemoryData(long baseAddress, String itemName, String imgName, boolean keyItem) {
		memoryMap.put("1.75", baseAddress);
		this.itemName = itemName;
		this.imgName = imgName;
		this.keyItem = keyItem;
		isItem = true;
	}

	public static void loadMemoryData() {
		String[] contents = FileUtils.readFromFile("memoryData");
		for (int i=0;i<contents.length;i++) {
			String[] split = contents[i].split(":");
			HashMap<String,Long> map = MemoryData.valueOf(split[0]).memoryMap;
			
			String[] split_data = split[1].split(";");
			int j=0;
			while (j<split_data.length) {
				String key = split_data[j++];
				boolean relative = Boolean.parseBoolean(split_data[j++]);
				if (relative) {
					map.put(key,GetRelativeValue(map,key));
				} else {
					Long newoffset = Long.decode(split_data[j++]);
					map.put(key, newoffset);
				}
			}
			System.out.println(MemoryData.valueOf(split[0])+":");
			DebugUtils.outputHashmap(map);
		}
	}
	
	static Long GetRelativeValue(HashMap<String,Long> memoryMap, String key) {
		switch (key) {
			case "1.851":{
				return memoryMap.get("1.75")+OffsetHelper.KEY_ITEM_OFFSET_V175_TO_V1851.getUpgradeAddress();
			}
			case "1.881":{
				return memoryMap.get("1.851")+
						OffsetHelper.KEY_ITEM_OFFSET_V175_TO_V1881.getUpgradeAddress()-
						OffsetHelper.KEY_ITEM_OFFSET_V175_TO_V1851.getUpgradeAddress();
			}
			case "1.90":{
				return memoryMap.get("1.881")+
						OffsetHelper.KEY_ITEM_OFFSET_V175_TO_V190.getUpgradeAddress()-
						OffsetHelper.KEY_ITEM_OFFSET_V175_TO_V1881.getUpgradeAddress();
			}
			default:{
				System.out.println("WARNING! key value "+key+" does not exist! Returning -1, which is probably not what you want.");
				DebugUtils.showStackTrace();
				return -1l;
			}
		}
	}
	
	public Long getOffset() {
		return memoryMap.get(Window.RABI_RIBI_VERSION);
	}
	
	enum OffsetHelper{
		KEY_ITEM_OFFSET_V175_TO_V1851(0x5744D0),
		KEY_ITEM_OFFSET_V175_TO_V1881(0x5754D0),
		KEY_ITEM_OFFSET_V175_TO_V190(0x5994E8);
		
		long upgradeAddress;
		
		OffsetHelper(long baseAddr) {
			this.upgradeAddress = baseAddr;
		}
		
		public long getUpgradeAddress() {
			return upgradeAddress;
		}
	}
	
	public boolean isItem() {
		return isItem;
	}
	
	public boolean isKeyItem() {
		return keyItem;
	}
	
	public Image getImage() {
		return Window.MAIN_WINDOW.image_map.get(imgName);
	}
}