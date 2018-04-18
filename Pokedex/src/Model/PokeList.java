package Model;

import java.util.ArrayList;
import Controller.*;

public class PokeList {

	private static ArrayList<Pokemon> pokeList = new ArrayList<Pokemon>();
	private static Pokemon selectedPokemon;
	
	public PokeList() {
		for(Pokemon pokemon : Rules.getPokemons()) {
			pokeList.add(pokemon);
		}
		
		setSelectedPokemon(0);
	}
	
	/**
	 * Get Pokemon by Index
	 * @param index
	 * @return
	 */
	public static Pokemon getByIndex(int index) {
		return pokeList.get(index);
	}
	
	public static Pokemon[] getAll() {
		Pokemon[] pokeArray = new Pokemon[pokeList.size()];
		for(int i = 0; i < pokeList.size(); i++) {
			pokeArray[i] = pokeList.get(i);
		}
		return pokeArray;
	}
	
	public static void setSelectedPokemon(int index) {
		selectedPokemon = pokeList.get(index);
	}
	
	public static Pokemon getSelectedPokemon() {
		return selectedPokemon;
	}
}
