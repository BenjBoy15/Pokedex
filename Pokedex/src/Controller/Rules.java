package Controller;

import java.util.ArrayList;

import Model.Pokemon;

public class Rules {
	private static int[] evolveLevel = {5, 25 , 50, 2147483647};
	private static int firstLevelXP = 10;
	private static double levelMultiplicator = 1.2;
	private static int trainedXPRange = 800;
	private static int trainedXPStart = 700;
	
	/**
	 * Returns the Level that is needed for the next Evolution
	 * @param acutalEvolveLevel
	 * @return
	 */
	static int getNextEvolveLevel(int acutalEvolveLevel) {
		return evolveLevel[acutalEvolveLevel];
	}
	
	/**
	 * Returns the XP that is needed for the first Level
	 * @return
	 */
	static int getFirstLevelXP() {
		return firstLevelXP;
	}
	
	/**
	 * Get Level Multiplicator
	 * @return
	 */
	static double getLevelMultiplicator() {
		return levelMultiplicator;
	}
	
	/**
	 * Get Range of XP that can possible be trained
	 * @return
	 */
	static int getTrainedXPRange() {
		return trainedXPRange;
	}
	
	/**
	 * get the starting XP that can be trained
	 * @return
	 */
	static int getTrainedXPStart() {
		return trainedXPStart + 1;
	}
	
	/** Pokemon initial value */
	public static Pokemon[] getPokemons() {
		ArrayList<Pokemon> pokemons = new ArrayList<Pokemon>();
		pokemons.add(new Pokemon(new String[] {"Floink", "Pignite", "Emboar"}, new String[] {"images/1A-Floink.png", "images/1B-Pignite.jpg", "images/1C-emboar.png"}));
		pokemons.add(new Pokemon(new String[] {"Shiggy", "Schillok", "Turtok"}, new String[] {"images/2A-shiggy.bmp", "images/2B-schillok.bmp", "images/2C-turtok.bmp"}));
		pokemons.add(new Pokemon(new String[] {"Glurak", "Glutexo", "Glumanda"}, new String[] {"Pignite.jpg", "Pignite.jpg", "Pignite.jpg"}));
		pokemons.add(new Pokemon(new String[] {"Bisasam", "Bisaflor", "Bisaflor"}, new String[] {"Pignite.jpg", "Pignite.jpg", "Pignite.jpg"}));
		
		return pokemons.toArray(new Pokemon[pokemons.size()]);
	}
}
