package Controller;

import Model.*;

public class SelectPokemon {
	
	/**
	 * Sets a Selected Pokemon in the Model
	 * @param index
	 */
	static void selectPokemon(int index) {
		PokeList.setSelectedPokemon(index);
	}
}
